package com.xonal.Tdd

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest._
import org.scalatest.matchers.should.Matchers._
import org.scalatest.prop.TableDrivenPropertyChecks

abstract class UnitSpec extends AnyFlatSpec
                        with Matchers
                        with OptionValues
                        with Inside
                        with Inspectors

class BinaryToDecimalSpec extends UnitSpec with TableDrivenPropertyChecks {
  /* "Base convertion utility" should "convert a binary number 100100111101 to decimal equivalent 2365" in {
    val decimal: Decimal = BaseConversion.binaryToDecimal(Binary("100100111101"))
    decimal.number shouldEqual "2365"
  }
  it should "convert binary number 11110001111110111 to decimal equivalent 123895" in {
    var decimal:Decimal = BaseConversion.binaryToDecimal(Binary("11110001111110111"))
    decimal.number shouldBe "123895"
  }
  it should "convert binary number 100000000000001110000001 to decimal equivalent 8389505" in {
    var decimal:Decimal = BaseConversion.binaryToDecimal(Binary("100000000000001110000001"))
    decimal.number should equal("8389505")

  } */
  it should "convert binary to decimal" in {
    val validCombos = Table(
      ("binary", "decimal"),
      ("100100111101", "2365"),
      ("11110001111110111", "123895"),
      ("100000000000001110000001", "8389505"),
      ("1011110101011101001101", "3102541")
    )
    forAll(validCombos){(binString: String, decString: String) =>
      var decimal = BaseConversion.binaryToDecimal(Binary(binString))
      decimal.number shouldBe decString
    }
  }
}
