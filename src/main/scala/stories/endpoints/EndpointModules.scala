package stories.endpoints

import com.softwaremill.macwire.wire

class EndpointModules() {

  lazy val topStoriesEndpoint: TopStoriesEndpoint = wire[TopStoriesEndpoint]
  lazy val healthCheckEndpoint: HealthCheckEndpoint = wire[HealthCheckEndpoint]

}
