package connectors

import javax.inject.{Inject, Singleton}
import models.{AllPokemon, Pokemon}
import play.api.libs.json.Json
import play.api.libs.ws.WSClient

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class PokemonConnector @Inject()(ws: WSClient) {

  def getAllPokemon: Future[AllPokemon] = {
    val request = ws.url("https://pokeapi.co/api/v2/pokemon?limit=151")
    request.get().map {
      response =>
        response.status match {
          case 200 => Json.parse(response.body).as[AllPokemon]
          case _ => AllPokemon(Seq())
        }
    }
  }

  def getSinglePokemon(pokemonNumber: String): Future[Pokemon] = {
    val request = ws.url(s"https://pokeapi.co/api/v2/pokemon/$pokemonNumber")
    request.get().map {
      response =>
        response.status match {
          case 200 => Json.parse(response.body).as[Pokemon]
          case ex =>
            println(response)
            throw new Error("OH NO I BLEW UP")
        }
    }
  }

}
