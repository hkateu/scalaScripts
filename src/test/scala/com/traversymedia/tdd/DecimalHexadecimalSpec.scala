package com.traversymedia.tdd

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.OptionValues
import org.scalatest.Inside
import org.scalatest.Inspectors
import org.scalatest.prop.TableDrivenPropertyChecks

class DecimalHexadecimalSpec extends UnitSpec with TableDrivenPropertyChecks{
  /*"base conversion utility" should "convert a number 1243 into a hexadecimal number 4DB" in {
    var hex: Hexadecimal = BaseConversion.decimalToHexadecimal(Decimal("1243"))
    hex.number should be ("4DB")
  }
  it should "convert a number 11111122 into a hexadecimal number A98AD2" in {
    var hex: Hexadecimal =
      BaseConversion.decimalToHexadecimal(Decimal("11111122"))
    hex.number should be ("A98AD2")
  } */
  it should "convert decimal to hex" in {
    val validCombos = Table(
      ("decimal", "hexadecimal"),
      ("1243", "4DB"),
      ("11111122", "A98AD2"),
      ("2435255412343", "2370088A677"),
      ("8765432", "85BFF8")
    )
    forAll(validCombos) { (decStr: String, hexStr: String) =>
      var hex = BaseConversion.decimalToHexadecimal(Decimal(decStr))
      hex.number shouldBe hexStr
    }
  }

}
