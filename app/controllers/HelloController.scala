package controllers

import javax.inject.Inject
import play.api.libs.json._
import play.api.mvc._

class HelloController @Inject() (cc: ControllerComponents)
  extends AbstractController(cc) {

//  def hello(): Action[AnyContent] = {
//    val actionBuilder: ActionBuilder[Request, AnyContent] =
//      controllerComponents.actionBuilder
//
//    actionBuilder.apply(new Status(200))
//  }

  // BaseControllerトレイトには、controllerComponents.actionBuilderと同じ処理を行うActionという名前のメソッドが定義されている
//  def hello(): Action[AnyContent] = Action.apply(new Status(200))

  // Scalaにおいてapplyメソッドは省略可能
//  def hello(): Action[AnyContent] = Action(new Status(200))

  // ステータスコード200は既にOkという定数オブジェクトがResults.scalaに定義されている
//  def hello(): Action[AnyContent] = Action(Ok)

  // 文字列を返却
  def hello(): Action[AnyContent] = {
    val result:Result = Ok("Hello World")
    Action(result.as("text/plain"))
  }

  def helloJson(): Action[AnyContent] = Action {
    val json: JsValue =
      Json.obj("hello" -> "world", "language" -> "scala")

    Ok(json)
  }

}