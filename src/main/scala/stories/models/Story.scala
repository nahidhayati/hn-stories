package stories.models

import stories._

case class Story(
  id: Int,
  title: String,
  commenters: List[Commenter]
) {

  lazy val topCommentersLimit: Int = config.getInt("topCommentersLimit")

  def tenTopCommenters: List[Commenter] = {
    commenters.sortWith(_.commentsCount > _.commentsCount).take(topCommentersLimit)
  }

}

case class Commenter(
  by: String,
  commentsCount: Int,
  totalCommentsCount: Int = 0
) {

  def updateTotalCommentsCount(stories: List[Story]): Commenter = {
    this.copy(
      totalCommentsCount = stories.map(_.commenters.filter(_.by == this.by).map(_.commentsCount).sum).sum
    )
  }

}
