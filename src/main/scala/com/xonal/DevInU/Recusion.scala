package com.xonal.DevInU

object Recursion extends App{
  def method1: String = {
    var currIter = 1

    def loop: String = {
      if(currIter % 5 != 0){
        println(currIter)
        currIter += 1
        loop
      }else{
        "done"
      }
    }
    loop
}

  def method2: String = {
    def loop(currIter: Int): String = {
      if(currIter % 5 != 0){
        println(currIter)
        loop(currIter + 1)
      }else{
        "done"
      }
    }
    loop(1)
}

  def method3: String = {
    var currIter = 1
    while(currIter % 5 != 0){
      println(currIter)
      currIter += 1
    }
    "done"
  }

  def fibo(n: Int): Int = {
      var iters: Int = 0
    def loop(x: Int, acc1: Int, acc2: Int): Int = {
      iters += 1
      if(x == 0) acc1
      else if(x == 1) acc2
      else
        loop(x - 1, acc2, acc1+acc2)
    }
    val result = loop(n, 0, 1)
    println(s"Iterations: $iters")

    result
  }

  println(fibo(6))
}
