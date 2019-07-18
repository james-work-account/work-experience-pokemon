package services

import connectors.PokemonConnector
import javax.inject.{Inject, Singleton}
import models.{MinifiedPokemon, Pokemon}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class HomeService @Inject()(pokemonConnector: PokemonConnector) {

  var state: Seq[MinifiedPokemon] = Seq()

  def getHomepageData: Future[Seq[MinifiedPokemon]] = {
    if(state.length != 151) {
      state = Seq()
      pokemonConnector.getAllPokemon.flatMap {
        allPokemon =>
          Future.sequence(allPokemon.results.map {
            pokemon =>
              pokemonConnector.getSinglePokemon(pokemon.getPokemonNumber).map {
                poke =>
                  MinifiedPokemon(poke.name, poke.sprites.front_default, poke.id, poke.types.map(_.`type`.name))
              }
          })
      }.map {
        allPokemon =>
          state = allPokemon // rudimentary caching...
          allPokemon
      }
    } else {
      Future.successful(state)
    }
  }

  def getSinglePageData(id: String): Future[Pokemon] = {
    pokemonConnector.getSinglePokemon(id)
  }
}
