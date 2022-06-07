package stories

import com.softwaremill.macwire._
import stories.clients.{ClientModule, ClientModuleImpl}
import stories.endpoints.EndpointModules
import stories.services.TopStoriesService

trait ServiceLoaderModule {

  lazy val client: ClientModule = wire[ClientModuleImpl]
  lazy val topStoriesService: TopStoriesService = wire[TopStoriesService]
  lazy val endpoints: EndpointModules = wire[EndpointModules]

}
