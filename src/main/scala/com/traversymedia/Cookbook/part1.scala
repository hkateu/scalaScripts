package Cookbook

object part1 extends App{
  val nieces: List[String] = List("sharon","ann", "rachael")
  
  val k = for(niece <- nieces) yield niece.toUpperCase()
  k.foreach(println)
  
  val fruits = List("apples", "bananas", "oranges")
  
  for(fruit <- fruits) println(fruit)
  val fruitsUpper = for(fruit <- fruits) yield {
    val s = fruit.toUpperCase()
    s
  }
  fruitsUpper.foreach(println)

  //counter
  for(i <- 0 until fruits.length){
    println(s"$i is ${fruits(i)}")
  }

  //counter using zip with index
  for((j,e) <- fruits.zipWithIndex){
    println(s"$e is $j")
  }

  val candidates = Map(1 -> "Herbert",2 -> "kateu", 3 -> "maraka", 4 -> "sharon")
  for ((id, name) <- candidates){
    println(s"$id belongs to $name")
  }

  fruits.map(_.toUpperCase()).foreach(println)
  fruits.foreach(e => println(e.toUpperCase()))

  for{
    i <- 1 to 10 if i%2 == 0
  } println(i)

  val searchMe = "peter piper picked a peck of pickled peppers"

  var p = 0
  for(i <- 0 until searchMe.length){
    if (searchMe(i) == 'p') {
      p += 1
      println(s"found p at $i")
    }
  }
  println(s"searchMe has $p p's")

  println(searchMe.count(_ == 'p'))

}
