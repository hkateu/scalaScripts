package com.traversymedia.rockTheJvm

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Promise

object WritableFutures extends App{
  val a = Future{
    42
  }

  object MyService {
    def produceAPreciousValue(theArg: Int) = "The meaning of life is " + (theArg/42)

    def submitTask[A](actualArg: A)(funciton: A => Unit): Boolean = {
      true
    }
  }

  val myPromise = Promise[String]()
  val myFuture = myPromise.future
  val furtherProcessing = myFuture.map(_.toUpperCase())
  def asynCall(promise: Promise[String]): Unit = {
    promise.success("Your value is here your majesty")
  }
  asynCall(myPromise)
  def gimmeMyPreciousValue(yourArg: Int): Future[String] = {
    val thePromise = Promise[String]()

    MyService.submitTask(yourArg){x: Int =>
      val preciousValue = MyService.produceAPreciousValue(x)
      thePromise.success(preciousValue)
    }

    thePromise.future
  }
}
