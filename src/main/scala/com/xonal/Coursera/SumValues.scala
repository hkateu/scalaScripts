package com.xonal.Coursera

object SumValues extends App{
  //function that sums values between two numbers
  def sumBetween(a: Int, b: Int): Int = {
    if(a > b) 0
    else
      a + sumBetween(a+1, b)
  }

  def sum(f: Int => Int, a: Int, b: Int): Int ={
    if(a > b) 0
    else
      f(a) + sum(f, a+1, b)
  }

  def sumRec(f:Int => Int)(a:Int, b:Int): Int = {
    def loop(a:Int, acc:Int): Int ={
      if(a > b) acc
      else loop(a+1,acc+f(a))
    }
    loop(a,0)
  }

  def product(f:Int=>Int)(a:Int, b:Int): Int = {
    if(a == 0) 0
    else if(a > b) 1
    else f(a) * product(f)(a+1, b)
  }
  def prodRec(f:Int=>Int)(a:Int, b:Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if(a == 0) 0
      else if(a > b) acc
      else loop(a+1, acc * f(a))
    }
    loop(a, 1)
  }

  def mapReduce(f: Int => Int, combine:(Int,Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if(a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
  }
  println(sumBetween(1,3))
  println(sumRec((x:Int)=>x*x)(1,3))
  println(product((x:Int) => x)(7,9))
  println(prodRec((x: Int) => x)(7,9))

}
