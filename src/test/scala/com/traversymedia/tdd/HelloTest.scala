package com.traversymedia.tdd

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should._
import org.scalatest.matchers.MatchResult
import org.scalatest.matchers.Matcher
case class Book(name:String, pages: Int)

class HelloTest extends AnyFunSuite {
  test("displaySalutations returns 'Hello World'"){
    assert(Hello.displaySalutations == "Hello World")
  }
}

class Hellotest extends AnyFlatSpec with Matchers {
  "A matcher" should "let us check Book values" in {
    //val num: String = "Hi"
    //num === 23
    //num should equal(23)
    //num should be(23)
    //num shouldBe an [Int]
    val book = Book("Eat", 123)
    book should have(
      'name ("Eat"),
      'pages (123)
    )
  }
//creating a custom matcher for file extensions
trait CustomMatchers {
  class FileEndsWithExtensionMatcher(expectedExtension: String) extends Matcher[java.io.File] {
    def apply(left: java.io.File) = {
      val name = left.getName
      MatchResult(
        name.endsWith(expectedExtension),
        s"""File $name did not end with extension $expectedExtension""",
        s""""File $name ended with extension $expectedExtension"""
      )
    }
  }
  def endWithExtension(expectedExtension: String) = new FileEndsWithExtensionMatcher(expectedExtension)
}

object CustomMatchers extends CustomMatchers




}
