package com.traversymedia.tdd

import org.scalatest.flatspec.AnyFlatSpec
import scala.collection.mutable.ListBuffer
import org.scalatest.BeforeAndAfter

class ExampleSpec extends AnyFlatSpec with BeforeAndAfter{
  trait MyBuilder{
    val myBuilder = new StringBuilder("ScalaTest is ")
  }
  trait MyBuffer{
    val myBuffer = ListBuffer("ScalaTest", "is")
  }
  val fixture = new {
    val builder = new StringBuilder
    val buffer = new ListBuffer[String]
  }

  before{
    val f = fixture
    f.builder.append("ScalaTest is ")
  }
  after{
    val f = fixture
    f.builder.clear()
  }
  "Testing" should "be easy" in {
    val f = fixture
    f.builder.append("easy!")
    assert(f.builder.toString === "ScalaTest is easy!")
    assert(f.buffer.isEmpty)
    f.buffer += "sweet"
  }

  it should "be fun" in {
    val f = fixture
    f.builder.replace(13,18,"fun!")
    assert(f.builder.toString === "ScalaTest is fun!")
    assert(f.buffer.length > 0)
  }
  it should "be cool and clear" in new MyBuffer with MyBuilder{
    myBuilder.append("clear!")
    myBuffer += ("cool!")
    assert(myBuilder.toString === "ScalaTest is clear!")
    assert(myBuffer === List("ScalaTest", "is", "cool!"))
  }
}
