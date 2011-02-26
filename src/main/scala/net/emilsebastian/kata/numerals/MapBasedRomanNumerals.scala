package net.emilsebastian.kata.numerals;

import scala.collection.immutable.SortedMap
import scala.collection.SortedSet

/**
 * Scala solution for the Roman Numerals Kata. Calculates the Roman numeral 
 * equivalent of an arbitrary integer in the range 1 to 3999.
 *
 * Second attempt, using a sorted map for storing all roman letters.
 *
 * @author emilsebastian
 */
class MapBasedRomanNumerals {

  val letters = SortedMap(1000 -> "M", 500 -> "D", 100 -> "C", 50 -> "L", 10 -> "X", 5 -> "V", 1 -> "I")(Ordering[Int].reverse)
	
  def toRoman(number: Int):String = {
    toRoman(number, letters.keySet)
  }
  
  private def toRoman(number: Int, factors: SortedSet[Int]):String = {
    
    val factor = factors.head
    val letter = letters(factor)
    
    val repetitions = number / factor
    val result = new StringBuilder(letter * repetitions)
    
    var remainder = number - factor * repetitions
        
    if (remainder > 0) {
      val prefixFactor = factor / (if (isPowerOfTen(factor)) 10 else 5)
      
      if (remainder >= factor - prefixFactor) {
        result.append(letters(prefixFactor) + letter)
        remainder -= factor - prefixFactor
      }
      
      result.append(toRoman(remainder, factors.tail))
    }
    
    result.toString
  }
  
  private def isPowerOfTen(number: Int) = {
    (StrictMath.log10(number) % 1) == 0
  }

}