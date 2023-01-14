package com.traversy
import scala.annotation

object fpInScala extends App {
  def factorial(n: Int): Int ={
    @annotation.tailrec
    def go(n: Int, acc: Int): Int = {
        if(n <= 0)acc
        else go(n-1,acc*n)
    }
    go(n,1)
  }

  def fibo(n:Int):Int = {
    @annotation.tailrec
    def go(n:Int, acc1: Int, acc2: Int): Int = {
        if(n == 0) {
            acc1
        }else if(n == 1){ 
            acc1
        }else{ 
            go(n-1, acc2, (acc1 + acc2))
        }
    }
    go(n, 0, 1)
  }

  def abs(n: Int): Int = {
    if(n < 0) -n
    else n
  }

  def formatFactorial(n:Int): String = {
    s"The factorial of $n is ${factorial(n)}"
  }

  def formatAbs(n: Int): String = {
    s"The absolute value of $n is ${abs(n)}"
  }

  def format(name: String, n: Int, f: Int => Int): String = {
    s"The $name of $n is ${f(n)}"
  }

  def findFirst(ss: Array[String], key: String): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
        if(n >= ss.length) -1
        else if(ss(n) == key) n
        else loop(n+1)
    }
    loop(0)
  }

  def findFirstGen[A](ss:Array[A], key:A): Int = {
    def loop(n: Int): Int = {
        if(n >= ss.length) -1
        else if (ss(n) == key) n
        else loop(n+1)
    }
    loop(0)
  }

  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
        def loop(n: Int): Boolean ={
            if(n >= as.length - 1) true
            else if(ordered(as(n),as(n+1))) false // if(ordered(as(n),as(n+1)) ==  false) false
            else loop(n+1)
        }
        loop(0)
  }

  def partial1[A,B,C](a:A, f:(A,B) => C): B=>C ={
    (b:B) => f(a: A, b: B)
  }

  def curry[A,B,C](f:(A,B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a: A, b:B)
  }

  def uncurry[A,B,C](f: A => B => C): (A,B) => C = {
    (a: A, b: B) => f(a:A)(b:B)
  }

  def decompose[A,B,C](f:B=>C, g:A=>B): A=>C = {
    (a:A) => f(g(a))
  }

  println(isSorted(Array(1,2,3,4,5), (a:Int, b: Int) => a < b))
  println(findFirstGen(Array(("Herb",6),("Kate", 5), ("gert", 4), ("rosern", 3)), ("Kate", 5)))
  println(format("absolute value", -8, abs))
  println(format("factorial", 5, factorial))
}
