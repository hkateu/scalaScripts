package com.xonal.Grokking
import scala.collection.mutable.ArrayBuffer

object sort extends App{
  val a = ArrayBuffer(156,141,35,94,88,61,111)
  def findSmallest(arr: ArrayBuffer[Int]): Int = {
    var smallest: Int = arr(0)
    var small_index: Int = 0
    for(i <- 0 until arr.length-1){
      if(a(i) < smallest){
        smallest = arr(i)
        small_index = i
      }
    }
    small_index
  }


  def sortSelection(arr: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    var sortedArray = ArrayBuffer[Int]()
    for(i <- 0 until arr.length){
      var smallest = findSmallest(arr)
      sortedArray += arr(smallest)
      arr -= arr(smallest)
    }
    sortedArray
  }

  println(sortSelection(a))
}
