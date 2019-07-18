package models

import play.api.libs.json.Reads

case class MinifiedPokemon(name: String, img: String, number: Int, types: Seq[String])

object MinifiedPokemon {

}
