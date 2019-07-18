package models

import play.api.libs.json.{Json, Reads}

case class InnerType(name: String)

object InnerType {
  implicit val reads: Reads[InnerType] = Json.reads[InnerType]
}
