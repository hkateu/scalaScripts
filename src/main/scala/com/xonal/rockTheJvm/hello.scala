package rockTheJvm

object hello extends App{
  val meaningOfLife: Int = 42

  val aBoolean = false

  val aString = "I love Scala"
  val aComposedString = "I"+" "+"Love"+" "+"Scala"
  val anInterpolatedString =  s"The meaning of life is $meaningOfLife"

  val anExpression = 2+3

  val ifExpression = if(meaningOfLife > 43) 56 else 999
  val chainedExpression =
    if(meaningOfLife > 43) 56
    else if(meaningOfLife < 0) -2
    else if(meaningOfLife > 999) 78
    else 0

  val aCodeBlock = {
    val aLocalValue = 67

    aLocalValue + 3
  }

  def myFucntion(x: Int, y: String): String = {
    y+" "+x
  }

  def factorial(n: Int): Int =
    if(n <= 1) 1
    else n * factorial(n-1)

  println("I love scala")

  def unitReturningFun(): Unit = {
    println("I dont like returning unit")
  }

  val theUnit = ()

}
