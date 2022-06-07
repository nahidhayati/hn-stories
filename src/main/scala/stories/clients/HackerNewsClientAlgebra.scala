package stories.clients

import stories.models.Item
import stories.utils.box.BoxComponent

trait HackerNewsClientAlgebra extends BoxComponent {

  def getTopStoryIds: Box[List[Int]]

  def getItem(id: Int): Box[Item]

}
