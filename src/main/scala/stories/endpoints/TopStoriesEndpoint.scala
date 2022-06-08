package stories.endpoints

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import stories.services.TopStoriesService
import stories._
import stories.models.ViewModel
import stories.utils.box.BoxToResponseComponent

class TopStoriesEndpoint(topStoriesService: TopStoriesService) extends BoxToResponseComponent{

  def routes: Route =
    path("top") {
      get {
        topStoriesService.getTopStories.map {
          stories => html.topStories(ViewModel.toViewModel(stories))
        }
      }
    }

}
