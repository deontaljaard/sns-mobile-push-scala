package sns.model

import io.circe.Json
import io.circe.syntax._

case class MobilePushMessage(platform: Platform, platformMessage: PlatformMessage) {
  val toJson: Json = Map(platform.name -> platformMessage.toJson.toString).asJson

  val toJsonString: String =
    toJson.toString
}
