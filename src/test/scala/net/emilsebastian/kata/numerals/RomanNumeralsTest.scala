package net.emilsebastian.kata.numerals

import org.scalatest.fixture.FixtureFlatSpec
import org.scalatest.matchers.ShouldMatchers

/**
 * Specifications for the various Roman Numerals Kata implementations.
 */
class RomanNumeralsTest extends FixtureFlatSpec with ShouldMatchers {

  val expectations = Map(1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V",
                         6 -> "VI", 7 -> "VII", 8 -> "VIII", 9 -> "IX", 10 -> "X",
                         111 -> "CXI", 222 -> "CCXXII", 333 -> "CCCXXXIII", 444 -> "CDXLIV", 555 -> "DLV",
                         666 -> "DCLXVI", 777 -> "DCCLXXVII", 888 -> "DCCCLXXXVIII", 999 -> "CMXCIX",
                         1990 -> "MCMXC", 2008 -> "MMVIII", 3999 -> "MMMCMXCIX")

  type FixtureParam = (Int, String)

  def withFixture(test: OneArgTest) {
    for ((number, numeral) <- expectations) {
      test((number, numeral))
    }
  }

  "Roman numerals" should "convert decimal numbers properly" in { fixture =>

    val (number, numeral) = fixture
    val r = new RomanNumerals()

    r.toRoman(number) should equal (numeral)
  }

  "Roman numerals (map based)" should "convert decimal numbers properly" in { fixture =>

    val (number, numeral) = fixture
    val r = new MapBasedRomanNumerals()

    r.toRoman(number) should equal (numeral)
  }

  "Roman numerals (with folding)" should "convert decimal numbers properly" in { fixture =>

    val (number, numeral) = fixture
    val r = new MapBasedRomanNumeralsWithFolding()

    r.toRoman(number) should equal (numeral)
  }
  
}