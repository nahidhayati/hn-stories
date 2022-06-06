package stories

import com.softwaremill.macwire._
import stories.endpoints.EndpointModules

trait ServiceLoaderModule {

  lazy val endpoints: EndpointModules = wire[EndpointModules]

}
