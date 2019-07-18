package models

import play.api.libs.json.{Json, Reads}

case class Sprites (front_default: String, back_default: String, front_shiny: String, back_shiny: String)

object Sprites {
  implicit val reads: Reads[Sprites] = Json.reads[Sprites]
}