package net.emilsebastian.kata.numerals;

/**
 * Scala solution for the Roman Numerals Kata. Calculates the Roman numeral 
 * equivalent of an arbitrary integer in the range 1 to 3999.  
 *
 * @author emilsebastian
 */
class RomanNumerals {
  
  def toRoman(number: Int):String = {
    toRoman(number, List((1000, "M"), (500, "D"), (100, "C"), (50, "L"), (10, "X"), (5, "V"), (1, "I")))
  }
  
  private def toRoman(number: Int, pairs: List[(Int, String)]):String = {
    
    val (factor, letter) = pairs.head
    val repetitions = number / factor
    
    val numerals = new StringBuilder(letter * repetitions)
    
    var n = number - factor * repetitions;
    
    if (n > 0) {
      val offset = if (isPowerOfTen(factor)) 2 else 1
      
      if (n >= factor - pairs(offset)._1) {
        numerals.append(pairs(offset)._2 + letter)
        n -= factor - pairs(offset)._1
      }
      
      numerals.append(toRoman(n, pairs.tail))
    }
    
    numerals.toString
  }
  
  private def isPowerOfTen(number: Int) = {
    (StrictMath.log10(number) % 1) == 0
  }
  
}
