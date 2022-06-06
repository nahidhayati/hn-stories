package stories.endpoints

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

class TopStoriesEndpoint {

  def routes: Route =
    path("top") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>HN Stories!</h1>"))
      }
    }

}
