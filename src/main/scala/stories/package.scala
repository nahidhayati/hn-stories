import akka.actor.ActorSystem
import com.typesafe.config.{Config, ConfigFactory}
import scala.concurrent.ExecutionContextExecutor

package object stories {

  implicit val actorSystem: ActorSystem = ActorSystem("stories")
  implicit val config: Config = ConfigFactory.load()
  implicit val ec: ExecutionContextExecutor = actorSystem.dispatcher

}
