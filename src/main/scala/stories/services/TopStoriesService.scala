package stories.services

import cats.implicits.catsStdInstancesForFuture
import stories._
import stories.models.{Commenter, Item, Story}
import stories.clients.ClientModule
import stories.utils.box.BoxComponent

class TopStoriesService(client: ClientModule) extends BoxComponent{

  def getTopStories: Box[List[Story]] = {
    client.hackerNewsClient.getTopStoryIds
      .flatMap(getStories)
      .map(updateCommenters)
  }

  private def getStories(storyIds: List[Int]): Box[List[Story]] = {
    storyIds.map {
      storyId =>
        client.hackerNewsClient.getItem(storyId).flatMap(getComments)
    }.toBoxList
  }

  private def getComments(story: Item): Box[Story] = {
    story.kids match {
      case None =>
        toBox(story.toStory)
      case _ =>
        story.kids.get
          .map(client.hackerNewsClient.getItem).toBoxList
          .map(getCommenters)
          .map(story.toStory)
    }
  }

  private def getCommenters(comments: List[Item]): List[Commenter] = {
    comments
      .filter(_.by.isDefined)
      .groupBy(_.by.get).map {
      case (k, v) =>
        Commenter(by = k, commentsCount = v.length)
    }.toList
  }

  private def updateCommenters(stories: List[Story]): List[Story] = {
    stories.map {
      story =>
        story.copy(commenters = story.commenters.map(_.updateTotalCommentsCount(stories)))
    }
  }

}
