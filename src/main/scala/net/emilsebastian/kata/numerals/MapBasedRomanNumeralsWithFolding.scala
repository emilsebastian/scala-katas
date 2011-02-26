package net.emilsebastian.kata.numerals

import scala.collection.immutable.SortedMap

/**
 * Scala solution for the Roman Numerals Kata. Calculates the Roman numeral 
 * equivalent of an arbitrary integer in the range 1 to 3999.
 *
 * Third attempt, using folding instead of recursion.
 *
 * @author emilsebastian
 */
class MapBasedRomanNumeralsWithFolding {

  val letters = SortedMap(1 -> "I", 5 -> "V", 10 -> "X", 50 -> "L", 100 -> "C", 500 -> "D", 1000 -> "M")
	
  def toRoman(number: Int):String = {

    val result = new StringBuilder()

    letters.keySet.foldRight(number)((factor, n) => {

      val repetitions = n / factor
      var remainder = n - factor * repetitions

      result.append(letters(factor) * repetitions)

      if (remainder > 0) {

	    val prefixFactor = factor / (if (isPowerOfTen(factor)) 10 else 5)
	  
        if (remainder >= factor - prefixFactor) {
          remainder -= factor - prefixFactor
          result.append(letters(prefixFactor) + letters(factor))
	    }
	  }

      remainder
    })

    result.toString
  }
  
  private def isPowerOfTen(number: Int) = {
    (StrictMath.log10(number) % 1) == 0
  }

}