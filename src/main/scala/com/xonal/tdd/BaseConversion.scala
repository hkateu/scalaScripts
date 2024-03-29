package com.xonal.Tdd

import scala.annotation.tailrec

object BaseConversion {
val hexTable =
  Array('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F')
  def decimalToHexadecimal(decimal: Decimal): Hexadecimal = {
    Hexadecimal(toHexadecimal(BigInt(decimal.number), "").toString)
  }
  def binaryToDecimal(binary: Binary): Decimal = {
    val seq = binary.number.reverse.zipWithIndex.map { case (a, i) =>
      a.toString.toInt * math.pow(2, i) }
    Decimal(seq.sum.toInt.toString)
  }
  def decimalToBinary(decimal: Decimal): Binary = {
    Binary(toBinary(BigInt(decimal.number), "").toString)
  }
  def hexadecimalToDecimal(hexadecimal: Hexadecimal) = ???
  @tailrec
  private def toBinary(num: BigInt, acc: String): String = {
    if (num < 2) (num.toInt + acc)
    else toBinary(num / 2, (num mod 2).toString ++ acc)
  }
  @tailrec
  private def toHexadecimal(num: BigInt, acc: String): String = {
    if (num < 16) (hexTable(num.toInt).toString + acc)
    else toHexadecimal(num / 16, hexTable((num mod 16).toInt).toString ++ acc)
  }
}
