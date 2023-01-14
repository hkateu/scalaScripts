package com.traversymedia.tdd
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.OptionValues
import org.scalatest.Inside
import org.scalatest.Inspectors
import org.scalatest.prop.TableDrivenPropertyChecks

class HexadecimalToDecimalSpec extends UnitSpec with TableDrivenPropertyChecks{
  /*"base conversion utility" should "convert hexadecimal number AB to decimal equivalent 171" in {
    val decimal:Decimal = BaseConversion.hexadecimalToDecimal(Hexadecimal("AB"))
    decimal.number shouldEqual "171"
  }
  it should "convert hexadecimal number 123AB to decimal equivalent 74667" in {
    val decimal:Decimal = BaseConversion.hexadecimalToDecimal(Hexadecimal("123AB"))
    decimal.number shouldBe "74667"
  }
  it should "convert hexadecimal number ABCDEF to decimal equivalent 11259375" in {
    val decimal:Decimal = BaseConversion.hexadecimalToDecimal(Hexadecimal("ABCDEF"))
    decimal.number should equal("11259375")
  }*/
  it should "convert hex to decimal" in {
    val validCombos = Table(
      ("decimal", "hexadecimal"),
      ("171", "AB"),
      ("74667", "123AB"),
      ("11259375", "ABCDEF"),
    )
    forAll(validCombos) { (decString: String, hexString: String) =>
      var decimal = BaseConversion.hexadecimalToDecimal(Hexadecimal(hexString))
      //decimal.number shouldBe decString
    }
  }
}
