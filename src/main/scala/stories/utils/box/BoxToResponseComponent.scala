package stories.utils.box

import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives.{complete, failWith, onComplete}
import akka.http.scaladsl.server.Route
import play.twirl.api.HtmlFormat
import scala.util.{Failure, Success}

trait BoxToResponseComponent extends BoxComponent {

  implicit def boxAppendableToResponse(result: Box[HtmlFormat.Appendable]): Route = {
    onComplete(result.value) {
      case Success(value) => value match {
        case Valid(v) =>
          val response =
            HttpResponse(
              status = StatusCodes.OK,
              entity = HttpEntity(ContentTypes.`text/html(UTF-8)`, v.body)
            )
          complete(response)
        case Fault(metaData: Metadata) =>
          complete(metaData.toHttpResponse)
      }
      case Failure(exception) => failWith(exception)
    }
  }

}
