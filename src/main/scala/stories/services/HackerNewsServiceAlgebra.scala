package stories.services

import stories.models.Item
import stories.utils.box.BoxComponent

trait HackerNewsServiceAlgebra extends BoxComponent {

  def getTopStories: Box[List[Int]]

  def getItem(id: Int): Box[Item]

}
