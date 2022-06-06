package specs

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import stories.Server.endpoints

class HealthCheckEndpointSpec extends AnyWordSpec with Matchers with ScalatestRouteTest {

  "Stories service" should {

    "returns \"pong\" for GET requests to the health check route" in {
      Get("/ping") ~> endpoints.healthCheckEndpoint.routes ~> check {
        status shouldEqual StatusCodes.OK
        responseAs[String] shouldEqual "pong"
      }
    }
  }
}
