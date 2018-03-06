package sns.model

import io.circe.Json

sealed trait PlatformMessage {
  def toJson: Json
}

case class AndroidMessage(collapseKey: String = "Welcome",
                          data: Map[String, String] = Map("message" -> "Harro!"),
                          delayWhileIdle: Boolean = true,
                          timeToLive: Int = 125,
                          dryRun: Boolean = false) extends PlatformMessage {

  val dataToJsonObj: Map[String, String] => Json = dataMap =>
    dataMap.foldLeft(Json.obj()) { case (jsonObj, (key, value)) =>
      jsonObj.deepMerge(Json.obj(key -> Json.fromString(value)))
    }

  override def toJson: Json = Json.obj(
    "collapse_key" -> Json.fromString(collapseKey),
    "data" -> dataToJsonObj(data),
    "delay_while_idle" -> Json.fromBoolean(delayWhileIdle),
    "time_to_live" -> Json.fromInt(timeToLive),
    "dry_run" -> Json.fromBoolean(dryRun)
  )

}