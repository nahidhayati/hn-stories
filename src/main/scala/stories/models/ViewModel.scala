package stories.models

import stories.config

case class ViewModel(
  stories: List[Story],
  headers: List[String],
  topCommentersLimit: Int
)

object ViewModel {

  val topCommentersLimit: Int = config.getInt("topCommentersLimit")

  private val ordinalSuffixes = List("st", "nd", "rd", "th")

  private def headers: List[String] =
    "Story" :: List.tabulate(topCommentersLimit)(
      (index: Int) =>
        s"${index + 1}${ordinalSuffixes(index.min(3))} Top Commenter"
    )

  def toViewModel(stories: List[Story]) =
    ViewModel(
      stories = stories,
      headers = headers,
      topCommentersLimit = topCommentersLimit
    )

}
