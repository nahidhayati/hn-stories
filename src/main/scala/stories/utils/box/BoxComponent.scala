package stories.utils.box

import cats.data.EitherT
import cats.implicits.catsStdInstancesForFuture
import scala.concurrent.Future
import scala.util.{Failure, Success}
import stories._

trait BoxComponent {

  val Valid: Right.type = Right
  val Fault: Left.type = Left

  type Box[T] = EitherT[Future, Metadata, T]
  type Value[T] = Either[Metadata, T]

  trait BoxMagnet[T] {
    def invoke(): Box[T]
  }

  def toBox[T](magnet: BoxMagnet[T]): Box[T] = magnet.invoke()

  def failedBox[T](metadata: Metadata): Box[T] = EitherT(Future[Value[T]](Fault(metadata)))

  implicit def entityToBoxMagnet[T](t: T): BoxMagnet[T] = () => EitherT(Future[Value[T]](Valid(t)))

  implicit def futureToBoxMagnet[T](t: Future[T]): BoxMagnet[T] = () => {
    EitherT(t.transform {
      case Success(value) => Success(Valid(value))
      case Failure(e) => Failure(e)
    })
  }

  implicit class BoxExtensions[T](box: Box[T]) {

    def ensureWith(f: T => Boolean)(fault: T => Metadata): Box[T] = {
      box.flatMap[Metadata, T] {
        case st if f(st) => box
        case sf => failedBox[T](fault(sf))
      }
    }

    def failureToMeta(metadata: Metadata): Box[T] = {
      EitherT(box.value.transform {
        case Success(value) => Success(value)
        case Failure(_) => Success(Fault(metadata))
      })
    }

  }

}
