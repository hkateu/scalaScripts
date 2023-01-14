package com.traversymedia.rockTheJvm

object CarriedPAF extends App{
  //carried function
  val superAdder: Int => Int => Int =
    x => y => x+y
  val add3 = superAdder(3)
  println(add3(5))
  println(superAdder(3)(5))

  //METHOD
  def curriedAdder(x: Int)(y: Int) = x + y
  val add4: Int => Int = curriedAdder(4)
  val add5 = curriedAdder(5)_

  //Exercise
  val simpleAddFunction = (x: Int, y: Int) => x + y
  def simpleAddMethod(x:Int, y: Int): Int = x+y
  def curriedAddMethod(x:Int)(y:Int): Int = x+y

  val add7 = (x: Int) => simpleAddFunction(7, x)
  val addd7 = simpleAddMethod(7, _: Int)
  val adddd7 = curriedAddMethod(7)_
  val ad7 = simpleAddFunction.curried(7)
  val dd7 = curriedAddMethod(7)(_)

  def myFormatter(x: String)(y:Double) = x.format(y)
  val format1 = myFormatter("%14.2f")_
  val format2 = myFormatter("%8.6f")_
  val format3 = myFormatter("%14.12f")_

  println(format1(math.Pi))
  println(format2(math.Pi))
  println(format3(math.Pi))

  def byName(n: => Int): Int = n+1
  def byFunction(f:() => Int): Int = f() + 1

  def method: Int = 42
  def parentMethod(): Int = 42

  println(byName(method))
  println(byName(parentMethod()))
  //println(byFunction(parentMethod()))

}
