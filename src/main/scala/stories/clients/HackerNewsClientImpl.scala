package stories.clients

import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpMethods, HttpRequest, StatusCodes}
import akka.http.scaladsl.unmarshalling.Unmarshal
import play.twirl.api.HtmlFormat
import stories._
import stories.models.{Item, ItemResponse, JsonSupport, Response, TopStoriesResponse}
import stories.utils.box.{BoxComponent, Metadata}
import scala.concurrent.Future

class HackerNewsClientImpl extends HackerNewsClientAlgebra with JsonSupport with BoxComponent {

  lazy val basePath: String = config.getString("services.hackerNews.host")
  lazy val itemsPath: String = basePath + config.getString("services.hackerNews.items")
  lazy val topStoriesPath: String = basePath + config.getString("services.hackerNews.topStories")
  lazy val topStoriesLimit: Int = config.getInt("topStoriesLimit")

  def getTopStoryIds: Box[List[Int]] = {
    val request = HttpRequest(method = HttpMethods.GET, uri = topStoriesPath)

    val response = for {
      response <- Http().singleRequest(request)
      responseStatus = response.status
      responseContent <- Unmarshal(response).to[List[Int]]
    } yield TopStoriesResponse(responseStatus, responseContent.take(topStoriesLimit))

    response.handleResponse.map(_.content)
  }

  def getItem(id: Int): Box[Item] = {
    val request = HttpRequest(method = HttpMethods.GET, uri = itemsPath.format(id))

    val response = for {
      response <- Http().singleRequest(request)
      responseStatus = response.status
      responseContent <- Unmarshal(response).to[Item]
    } yield ItemResponse(responseStatus, responseContent)

    response.handleResponse.map(_.content)
  }

  implicit class HandleResponse[T](res: Future[Response[T]]) {

    val error: HtmlFormat.Appendable = html.error()

    def handleResponse: Box[Response[T]] = {
      toBox(res)
        .failureToMeta(Metadata(StatusCodes.ServiceUnavailable, error))
        .ensureWith(_.status == StatusCodes.OK)(_ =>
          Metadata(StatusCodes.ServiceUnavailable, error)
        )
    }

  }

}
