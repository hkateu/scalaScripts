package rockTheJvm

object FunctionalProgramming extends App{
  class Person(name: String){
    def apply(age: Int): String = s"I am aged $age"
  }

  val bob = new Person("bob")
  bob.apply(43)
  bob(43)

  val simpleFunction = new Function1[Int,Int]{
    override def apply(x: Int): Int = x + 1
  }

  simpleFunction.apply(23)
  simpleFunction(23)

  val stringconcat = new Function2[String,String,String]{
    override def apply(y1: String, y2: String): String = y1 + y2
  }

  stringconcat("I love", " Scala")

  //syntactic sugar
  val doubler: Function1[Int,Int] = (x: Int) => x * 2
  doubler(3)

  val doubler2: Int => Int = (x: Int) => x * 2

  val allPairs = List(1,2,3).flatMap(num => List('a','b', 'c').map(ltr => s"$num-$ltr"))

  //forComprehension

  val altPairs = for{
    numbers <- List(1,2,3)
    letters <- List('a', 'b', 'c')
  } yield s"$numbers-$letters"

  // class Composite[A,B]
  // val myComp: Int Composite String = ???

  // class -->[A,B]
  // val g: Int --> String = ???

  object lessThan{
    def unapply(n: Int): Boolean = n < 50
  }

  object even{
    def unapply(n: Int): Boolean = n % 2 == 0 
  }

  val anInt = 47  
  val checkInt = anInt match {
    case even() => "IsEven"
    case lessThan() => "Is Less than"
    case _ => "Something else"
  }
  println(checkInt)
}
