package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}
import services.HomeService
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class HomeController @Inject()(homeService: HomeService, cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action.async { implicit request =>
    homeService.getHomepageData.map {
      pokemonSeq =>
        Ok(views.html.index(pokemonSeq))
    }
  }

  def singlePage(id: String) = Action.async { implicit request =>
    homeService.getSinglePageData(id).map {
      pokemon =>
        Ok(views.html.singlePage(pokemon))
    }
  }

}
