package net.emilsebastian.kata.bowling

/**
 * Represents a sequence of bowling rolls that belong to the same frame.
 *
 * @author emilsebastian
 */

class BowlingFrame(f: Int, s: Int, t: Int) {

  require(validRoll(f))
  require(validRoll(s))
  require(validRoll(t))

  val firstRoll = f;
  val secondRoll = s;
  val thirdRoll = t;

  def this(f: Int) = this (f, 0, 0)
  def this(f: Int, s: Int) = this (f, s, 0)

  def isSpare = (f < 10 && f + s == 10)
  def isStrike = (f == 10)

  private def validRoll(roll: Int) = (roll >= 0 && roll <= 10)

}