package com.xonal.Programing_in_scala

import scala.util.Try

object functional_objects extends App{
  class Rational(n: Int, d: Int) {
    require(d != 0)
    private val g = gcd(n.abs, d.abs)
    val numer: Int = n/g
    val denom: Int = d/g
    def this(n: Int) = this(n:Int, 1) // auxillary constructor
    def +(that: Rational): Rational =
      new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
        )
    def +(i: Int): Rational = new Rational(numer + i * denom, denom)
    def -(that: Rational): Rational =
      new Rational(
        numer * that.denom - that.numer * denom,
        denom * that.denom
      )
    def -(i: Int) = new Rational(numer - i * denom, denom)
    def *(that: Rational): Rational =
      new Rational(this.numer * that.numer, this.denom * that.denom)
    def *(i: Int) = new Rational(this.numer * i, this.denom)
    def /(that: Rational): Rational =
      new Rational(this.numer * that.denom,that.numer * this.denom)
    def /(i: Int) = new Rational(this.numer, i * this .denom)
    def lessThan(that: Rational): Boolean = this.numer * that.denom < that.numer * this.denom
    def max(that: Rational): Rational = {
      if(this.lessThan(that)) that else this
    }
    override def toString = s"$numer/$denom"
    private def gcd(a: Int, b:Int): Int = {
      if(b == 0) a else gcd(b, a % b)
    }
    //private def rationalToInt(g: Rational) = g match {
      //case g(x: Int, y:Int) if (y == 1) => x
      //case value => value
    //}
  }


    val myRational = Try{
    new Rational(1,3)
  }.getOrElse{
    "Denominator must be zero"
  }

  println(myRational)

  val oneHalf = new Rational(1,2)
  val twoThirds = new Rational(2,3)
  val added = oneHalf + twoThirds
  println(added)

  val five = new Rational(5)
  println(five)

  println(five lessThan oneHalf)
  println(added max five)

  println(new Rational(66,42))
  println(new Rational(1,2) * new Rational(1,2))
  println(new Rational(1,2) * 2)
}
