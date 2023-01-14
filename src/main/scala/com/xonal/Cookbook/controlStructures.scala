package com.xonal.Cookbook

import scala.annotation.switch

object ControlStructures extends App{
  val i: Int = 1
  val x = (i: @switch) match {
    case 1 => "one"
    case 2 => "two"
    case _ => "none"
  }

  final case class Person(name: String, age: Int)
  val bob: Person = Person("bob", 42)

  val check: String = bob match {
    case p @ Person(_,_) => s"found ${p.name} age ${p.age}";
    case _ => "found something else"
  }
  println(x)
  println(check)

  @annotation.tailrec
  def whilst(testCond: => Boolean)(body: => Unit): Unit = {
    if(testCond){
      body
      whilst(testCond)(body)
    }
  }

  var j: Int = 0
  whilst(j < 5){
    j += 1
    println(j)
  }

  //println(j)
}
