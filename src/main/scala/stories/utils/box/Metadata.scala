package stories.utils.box

import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpResponse, StatusCode}
import play.twirl.api.HtmlFormat

case class Metadata(httpStatus: StatusCode, error: HtmlFormat.Appendable) {

  def toHttpResponse: HttpResponse = {
    HttpResponse(
      status = httpStatus,
      entity = HttpEntity(ContentTypes.`text/html(UTF-8)`, error.body)
    )
  }

}
