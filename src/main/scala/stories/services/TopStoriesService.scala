package stories.services

import cats.implicits.catsStdInstancesForFuture
import stories._
import stories.models.{Commenter, Item, Story}
import stories.clients.ClientModule
import stories.utils.box.BoxComponent

class TopStoriesService(client: ClientModule) extends BoxComponent{

  /** Getting all top stories with their commenters */
  def getTopStories: Box[List[Story]] = {
    client.hackerNewsClient.getTopStoryIds
      .flatMap(getStories)
      .flatMap(_.map(addCommentsToStory).toBoxList)
      .map(calcCommentersTotalComments)
  }

  /** Getting all story items for the given ids */
  private def getStories(storyIds: List[Int]): Box[List[Item]] = {
    storyIds.map(client.hackerNewsClient.getItem).toBoxList
  }

  /** Getting all comment items and their replies recursively for the given ids */
  private def getComments(commentIds: List[Int]): Box[List[Item]] = {
    commentIds.map(client.hackerNewsClient.getItem).toBoxList.flatMap {
      items =>
        val kids = items.flatMap(_.kids.getOrElse(Nil))
        kids match {
          case Nil => toBox(items)
          case _ => getComments(kids).map(_ ++ items)
        }
    }
  }

  /** Adding comments to a story */
  private def addCommentsToStory(storyItem: Item): Box[Story]  = {
    getComments(storyItem.kids.getOrElse(Nil))
      .map(comments => storyItem.toStory(getStoryCommenters(comments)))
    }

  /** Converting comments to commenters for a story*/
  private def getStoryCommenters(comments: List[Item]): List[Commenter] = {
    comments
      .filter(_.by.isDefined)
      .groupBy(_.by.get).map {
      case (k, v) =>
        Commenter(by = k, commentsCount = v.length)
    }.toList
  }

  /** Calculating the total comments count of all user */
  private def calcCommentersTotalComments(stories: List[Story]): List[Story] = {
    stories.map {
      story =>
        story.copy(commenters = story.commenters.map(_.updateTotalCommentsCount(stories)))
    }
  }

}
