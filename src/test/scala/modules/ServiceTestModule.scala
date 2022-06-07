package modules

import com.softwaremill.macwire.wire
import org.scalamock.scalatest.AsyncMockFactory
import stories.services.TopStoriesService
import stories.clients.{HackerNewsClientAlgebra, ClientModule}

trait ServiceTestModule extends AsyncMockFactory {

  lazy val topStoriesService: TopStoriesService = wire[TopStoriesService]
  lazy val client: ClientModule = new ClientModule {
    override val hackerNewsClient: HackerNewsClientAlgebra = stub[HackerNewsClientAlgebra]
  }

}
