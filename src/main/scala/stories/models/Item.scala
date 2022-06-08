package stories.models

case class Item(
  id: Int,
  by: Option[String] = None,
  `type`: String,
  kids: Option[List[Int]] = None,
  title: Option[String] = None
) {

  def toStory(commenters: List[Commenter]): Story = {
    Story(id = id, title = title.getOrElse("Story"), commenters)
  }

}
