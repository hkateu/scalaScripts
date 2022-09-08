package rockTheJvm

object PatternMatchingTricks extends App{
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 44)
  val bobGreeting = bob match {
    case Person(n,a) => s"Hi my name is $n and am $a years old"
    case _ => "This is not a person"
  }

  println(bobGreeting)

  //list extractors
  val myList = List(1,2,3,4,5)

  //specific list with few members
  val checkList = myList match{
    case List(_,_,3,someThing) => s"list contains 3 and $someThing after"
    case _ => "doesnt match"
  }
  println(checkList)

  //large lists coming in
  val processList =  myList match{
    case head :: tail => s"First element is $head and $tail comes after"
    case _ => "Not a list"
  }
  println(processList)

  //match lists of arbitraty length
  val processList2 = myList match{
    case List(_,2,_*) => "Only care about the 2"
    case _ => "Not a list with 2"
  }
  println(processList2)

  val checkListEnd = myList match {
    case List(1,_*) :+4 => "List ends with 4"
    case List(1,_*) :+a => s"Checked ends with a $a"
    case _ => "Must be a mistake"
  }
  println(checkListEnd)

  def giveMeAValue():Any = 42

  val checkType = giveMeAValue match {
    case _:String => "Got a string"
    case _:Int => "Got an Int"
    case _ => "Got something else"
  }

  println(checkType)

  def reqMoreInfo(g: Person) = s"${g.name} is a good person"

  //name binding
  val moreInfoBob = bob match {
    case p @ Person(n,a) => s"MoreInfo: ${reqMoreInfo(p)}"
    case _ => "An error occured"
  }

  println(moreInfoBob)

  val likeList = myList match {
    case List(1,_*) | List(_,_,3,_*) => "I like this list"
    case _ => "I hate this list"
  }

  println(likeList)
}
