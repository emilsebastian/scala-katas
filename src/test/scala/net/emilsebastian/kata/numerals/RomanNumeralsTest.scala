package net.emilsebastian.kata.numerals

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class RomanNumeralsTest extends FlatSpec with ShouldMatchers {

  "Roman numerals" should "convert decimal numbers properly" in {

    val r = new RomanNumerals()

    r.toRoman(1) should equal ("I")
    r.toRoman(2) should equal ("II")
    r.toRoman(3) should equal ("III")
    r.toRoman(4) should equal ("IV")
    r.toRoman(5) should equal ("V")
    r.toRoman(6) should equal ("VI")
    r.toRoman(7) should equal ("VII")
    r.toRoman(8) should equal ("VIII")
    r.toRoman(9) should equal ("IX")
    r.toRoman(10) should equal ("X")
    r.toRoman(2008) should equal ("MMVIII")
    r.toRoman(1990) should equal ("MCMXC")
  }
  
}
