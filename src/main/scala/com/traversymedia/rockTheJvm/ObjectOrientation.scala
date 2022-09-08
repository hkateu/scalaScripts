package rockTheJvm

object ObjectOrientation extends App{
  //class and its instance
  class Animal{
    //define fields
    val age: Int = 0

    //define methods
    def eat() = println("I'm eating")

    //from companion object
    def hasShortLegs():String = {
      if(Animal.shortLegs) "yes"
      else "no"
    }
  }
  val anAnimal = new Animal

  //inheritence
  class Dog(val name: String) extends Animal

  val aDog = new Dog("Lassie")

  //constructor arguments are not fields: To promote them to fields add val at the beginning of the argument
  aDog.name

  //subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")

  //eat method will be called from the Dog Class
  aDeclaredAnimal.eat() //last declared called at runtime

  //abstract class
  abstract class Walking {
    val hasLegs = true // by default public
                       //private only class has access to this method
                       //protected class and its descendants have access to this method but not outside the class
    def walks(): Unit
  }

  //interface = ultimate abstract type
  trait Carnivore{ //keep traits for characteristics we can add to concrete classes
    def eat(animal: Animal): Unit
  }

  //scala allows single class inheritence but multiple trait inheritence
  class Crocodile extends Animal with Carnivore{
    def eat(animal: Animal): Unit = println("Iam eating you animal")
   }

  //anonymous class
  val dinosaur = new Carnivore{
    def eat(animal: Animal): Unit  = println("Iam a dinosaur so i can eat anything")
  }

  //singleton
  object MySingleton {
    val mySpecialType: Int = 56441
    def mySpecialMethod(): Int = 56474
    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // same as above, compiler automatically calls apply method

  object Animal{ // companion object
    val canLiveForever = false
    private val shortLegs = true
  }

  val canLF = Animal.canLiveForever

  //exceptions
  try {
    val hh: String = null
    hh.length
  } catch {
    case e: Exception => "something faulty happened"
  } finally{
    //execute some code no matter what
  }

  //generics
  abstract class MyList[T] {
    val head: T
    val tail: MyList[T]
  }

}
