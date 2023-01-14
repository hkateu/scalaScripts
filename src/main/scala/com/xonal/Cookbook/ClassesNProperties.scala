package com.xonal.Cookbook


object classesNProperties extends App{
  class Person(firstName: String, secondName: String){
    println("The constructor is starting")
    override def toString: String = s"$firstName $secondName"
    val HOME = System.getProperty("user.home")
    def printHome = {
      println(s"HOME: $HOME")
    }
    def printName = {
      println(this)
    }
    println("The constructor is ending")
  }

  val me = new Person("Herbert", "Kateu")
  me.printHome
  me.printName

  class Pizza(var crustSize: Int, var crustType: String){
    def this(crustSize: Int){
      this(crustSize, Pizza.DEFAULT_CRUST_TYPE)
    }
    def this(crustType: String){
      this(Pizza.DEFAULT_CRUST_SIZE, crustType)
    }
    def this(){
      this(Pizza.DEFAULT_CRUST_SIZE, Pizza.DEFAULT_CRUST_TYPE)
    }
    override def toString = s"A $crustSize inch pizza with a $crustType crust"
  }

  object Pizza{
    val DEFAULT_CRUST_SIZE = 12
    val DEFAULT_CRUST_TYPE = "THIN"
  }

  val p1 = new Pizza(Pizza.DEFAULT_CRUST_SIZE, Pizza.DEFAULT_CRUST_TYPE)
  val p2 = new Pizza(Pizza.DEFAULT_CRUST_SIZE)
  val p3 = new Pizza(Pizza.DEFAULT_CRUST_TYPE)
  val p4 = new Pizza

  case class Persons(name: String, age: Int)

  object Persons{
    def apply() = new Persons("<no name>", 0)
    def apply(name: String) = new Persons(name, 0)
  }

  val d1 = Persons()
  val d2 = Persons("Herbert")
  val d3 = Persons("Herbert", 45)


  println(d1)
  println(d2)
  println(d3)

  //d1.name = "Zack"
  //d1.age = 47
  //println(d1)
  class Order private(number: Int) {
    override def toString: String = s"$number orders pending"
  }

  //val order = new Order(45)
}
