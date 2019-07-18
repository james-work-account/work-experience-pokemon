package models

import play.api.libs.json.{Json, Reads}

case class OuterType(`type`: InnerType)

object OuterType {
  implicit val reads: Reads[OuterType] = Json.reads[OuterType]
}