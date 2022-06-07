package stories.utils.box

import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpResponse, StatusCode}

case class Metadata(httpStatus: StatusCode, message: String) {

  def toHttpResponse: HttpResponse = {
    HttpResponse(
      status = httpStatus,
      entity = HttpEntity(ContentTypes.`text/html(UTF-8)`, message)
    )
  }

}
