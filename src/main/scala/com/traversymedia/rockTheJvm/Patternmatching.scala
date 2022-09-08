package rockTheJvm

import scala.util.Try
import scala.util.Success
import scala.util.Failure
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object PatternMatching extends App{
 //switch statement
  val anInteger: Int = 55
  val order: String = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }

  println(order)

  case class Person(name:String, age: Int)
  val bob = Person("Bob", 43)
  val personGreeting: String = bob match{
    case Person(n,a) => s"Hi my name is $n and iam $a years old"
    case _ => "Something else"
  }

  def methodWhichThrowException():String = throw new Exception()
  val aTry = Try(methodWhichThrowException)

  val processTry = aTry match {
    case Success(a) => s"return $a successfully"
    case Failure(e) => s"something went wrong $e"
  }

  def methodWithNull(): String = "Hello, scala"
  val methodReturns = Option(methodWithNull)

  val mRetuns = methodReturns match{
    case Some(k) => s"Returned $k"
    case None => "Found nothing"
  }

  methodReturns.getOrElse("Found nothing")

  val aFuture = Future({
                         println("coming out")
                         Thread.sleep(1000)
                         println("second value")
                       })
}
