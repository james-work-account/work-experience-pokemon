package models

import play.api.libs.json.{Json, Reads}

case class AllPokemon(results: Seq[AllResult])

object AllPokemon {
  implicit val reads: Reads[AllPokemon] = Json.reads[AllPokemon]
}