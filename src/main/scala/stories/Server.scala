package stories

import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._

object Server extends App with ServiceLoaderModule {

  val host = config.getString("http.host")
  val port = config.getInt("http.port")
  val bindFut = Http().newServerAt(host, port).bind(
    pathPrefix("stories") {
      endpoints.topStoriesEndpoint.routes ~
        endpoints.healthCheckEndpoint.routes
    }
  )

  println(s"Stories service is started and accessible via $host:$port")

}
