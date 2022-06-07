package stories.models

import akka.http.scaladsl.model.StatusCode

sealed trait Response[T] {

  val status: StatusCode
  val content: T

}

case class ItemResponse(status: StatusCode, content: Item) extends Response[Item]

case class TopStoriesResponse(status: StatusCode, content: List[Int]) extends Response[List[Int]]
