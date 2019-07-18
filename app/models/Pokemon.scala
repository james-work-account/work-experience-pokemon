package models

import play.api.libs.json.{Json, Reads}

case class Pokemon(id: Int, name: String, sprites: Sprites, types: Seq[OuterType], height: Int, weight: Int)

object Pokemon {
  implicit val reads: Reads[Pokemon] = Json.reads[Pokemon]
}