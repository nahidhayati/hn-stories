package stories.clients

import com.softwaremill.macwire.wire

class ClientModuleImpl extends ClientModule {

  override lazy val hackerNewsClient: HackerNewsClientAlgebra = wire[HackerNewsClientImpl]

}
