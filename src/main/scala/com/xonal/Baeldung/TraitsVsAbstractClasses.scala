package com.xonal.Baeldung

trait FruitTrait {
  val name: String
  val color: String
  def taste(): Unit
}

trait FruitTrait2 {
  val name: String
  val color: String
  def taste(): Unit = println(s"I love my $color $name")
}

trait NumTrait {
  val number: Int
}

abstract class FruitAbstractClass{
  val name: String
  val color: String
  def taste(): Unit
}

abstract class FruitAbstractClass2{
  val name: String = "Banana"
  val color: String = "Yellow"
  def taste(): Unit
}

abstract class NumAbstractClass{
  val number: Int
}

//trait FruitTrait3(n: String, c: String){
  //val name: String = n
  //val color: String = c
  //def taste(): Unit = println(s"I love my $color $name")
//}


abstract class FruitAbstractClass3(n:String, c: String){
  val name: String = n
  val color: String = c
  def taste(): Unit
}

class MyFruit1 extends FruitTrait with NumTrait{
  override val name: String = "Apple"
  override val color: String = "Green"
  override val number: Int = 3
  override def taste(): Unit = println(s"my $number $color " + name + "s taste yummy")
}

class MyFruit2 extends FruitAbstractClass {
  override val name: String = "Apple"
  override val color: String = "Red"
  override def taste(): Unit = println(s"my $color $name taste sweet")
}


object TraitsVsAbstractClasses {
  def main(args: Array[String]) = {
    val fruit = new MyFruit1
    fruit.taste // my Green Apple tastes yummy
                //traits or objects may not hace parameters
    val fruit2 = new MyFruit2
    fruit2.taste // my Red Apple tastes sweet
                 // compiles
                 // FruitNumAbstractClass needs to be a trait to be mixed in
    //val mytrait = new FruitAbstractClass
  }
}
