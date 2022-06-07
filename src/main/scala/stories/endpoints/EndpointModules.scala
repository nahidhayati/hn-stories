package stories.endpoints

import com.softwaremill.macwire.wire
import stories.services.TopStoriesService

class EndpointModules(topStoriesService: TopStoriesService) {

  lazy val topStoriesEndpoint: TopStoriesEndpoint = wire[TopStoriesEndpoint]
  lazy val healthCheckEndpoint: HealthCheckEndpoint = wire[HealthCheckEndpoint]

}
