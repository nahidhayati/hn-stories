package stories.endpoints

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

class HealthCheckEndpoint {

  def routes: Route =
    path("ping") {
      get {
        complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, "pong"))
      }
    }

}
