package Cookbook

object hello extends App{
  //implicit args
  def methodWithImplcitArgs(implicit n:Int): Unit = {
    println(n)
  }
  implicit val num = 43

  methodWithImplcitArgs

  implicit class MyRichInteger(k: Int){
    def isEven: Boolean = k % 2 == 0
  }

  println(43.isEven)

  implicit class EnrichedString(h: String){
    def newString: String = {
      h.map(c => (c+1).toChar)
    }
  }

  println("hello".newString)
}
