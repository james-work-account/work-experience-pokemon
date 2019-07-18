package models

import play.api.libs.json.{Json, Reads}

case class AllResult(url: String) {
  def getPokemonNumber: String = url.split("/").filterNot(_ == "").last
}

object AllResult {
  implicit val reads: Reads[AllResult] = Json.reads[AllResult]
}
