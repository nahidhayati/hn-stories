package specs

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import stories.Server.endpoints

class TopStoriesEndpointSpec extends AnyWordSpec with Matchers with ScalatestRouteTest {

  "Stories service" should {

    "returns without error for GET requests to the top stories route" in {
      Get("/top") ~> endpoints.topStoriesEndpoint.routes ~> check {
        status shouldEqual StatusCodes.OK
      }
    }
  }
}
