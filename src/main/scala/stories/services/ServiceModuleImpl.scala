package stories.services

import com.softwaremill.macwire.wire

class ServiceModuleImpl extends ServiceModule {

  override lazy val hackerNewsService: HackerNewsServiceAlgebra = wire[HackerNewsServiceImpl]

}
