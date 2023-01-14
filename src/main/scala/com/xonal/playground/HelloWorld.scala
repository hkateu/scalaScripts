package com.xonal.Playground

object HelloWorld extends App{
  //val name = "mark"
  //val age = 18.5
  //println(name +" is "+ age + " years old")

  //s string interpolation
 // println(s"$name is $age years old")

  //f string interpolation for constructing type safe
  //println(f"$name%s is $age%f years old")

  //raw string interpolation
  //println(s"Hello \nworld")
  //println(raw"Hello \nworld")

  //If else statements
  //val x = 20 //assignment single =
  //val y = 30
  //var res = ""

  //if(x == 20 && y == 30) // equality double equals
    //res = ("x == 20")
  //else
    //res = ("x != 20")

  //println(res)

  //val res2 = if(x == 20) "x == 20" else "x !=20"

  //loops
  // while loop
  /*  var x = 0

  while(x < 10){
    println(s"x = $x")

    x += 1
  } */

  //do while no longer supported
  //var y = 0
  /*  do{
    println(s"y = $y")
    y += 1
  }while(y < 10) */

  //for loop
  /*  val lst = List(1,2,3,4,5,6,78)
  val result = for(i <- lst; if i < 6) yield {
    i * i
  }
  println(result) */

  //match expressions
  /* val age = 18
  age match{
    case 200 => println(age)
    case _ => println(s"failed to capture $age")
  } */

  /*def multiply(x:Int, y:Int): Int = x/y
  println(multiply(10,5))

  val add = (x: Int, y: Int) => x + y
  println(add(10,23)) */

  /* def math(x: Double, y: Double, f:(Double, Double) => Double): Double = f(x, y);
  val result = math(50, 20, (x,y) => x+y)
  println(result) */

  /*
  val sum = (a: Int, b: Int, c: Int) => a+b+c

  val f = sum(1,2,_:Int)
  println(f(3)) */

  //def add(x: Int, y: Int) = x+y
  //curried function
  /* def add2(x: Int) = (y: Int) => x+y
  def add3(x: Int)(y:Int) = x+y
  println(add(1,2))
  println(add2(1)(2))
  println(add3(1)(2))

  val sum50 = add3(50)_
  println(sum50(30))


  val sum40 = add2(40)
  println(sum40(30)) */

/*  val str1: String = "Hello World"
  val str2: String = " Max"
  println(str1.length())
  println(str1.concat(str2))
  println(str1 + str2)

  val num1 = 75
  val num2 = 100.25

  printf("(%d -- %f -- %s)", num1,num2,str1)
  println("(%d -- %f -- %s)".format(num1,num2,str1))

 */

/*  import Array._

  val myarray: Array[Int] = new Array[Int](4)
  val myarray2 = new Array[Int](5)
  val myarray3 = Array(1,2,3,4,5,6,8)

  myarray(0) = 20
  myarray(1) = 50
  myarray(2) = 10
  myarray(3) = 30

  println(myarray)
  val result = concat(myarray, myarray3)

  result foreach println
 */
/*
  val mylist: List[Int] = List(1,2,3,4,5,6)
  val names: List[String] = List("Max", "Tom", "John")

  println(0 :: mylist)
  println(mylist)
  println(names)

  println(1 :: 2 :: 6 :: Nil)
  println(names.tail)
  println(mylist.head)
  println(names.isEmpty)
  println(mylist.reverse)
  println(List.fill(5)(2))

  mylist.reduce(_+_)
 */
/*
  val myset: Set[Int] = Set(1,2,3,4,5,6,7,8)
  println(myset(8))

  val myset2: Set[Int] = Set(4,5,6,7,33,44)

  println (myset ++ myset2)

 */
  /*
val mymap: Map[Int,String] = Map(1 -> "Herb", 3 -> "zeno")

  val xx = mymap.view.mapValues{x =>
    x.toUpperCase()
  }.toMap

  val ll = mymap.transform((k,v) => v.toUpperCase)
  println(ll)
   */
  //println(xx)
  //

  /*
  class User(private val name: String, val age: Int){
    //Auxillary Constructors
    def this(){
      this("Tom", 32)
    }
    def this(name: String){
      this(name, 32)
    }
  }
  var user1 = new User("Max", 28)
  var user2 = new User()
   var user3 = new User("Max")
   */

/*
  class Polygon {
    def area: Double = 0.0;
  }

 var poly = new Polygon
 */

  val s = "helloo"
  s.foreach(println)
}
