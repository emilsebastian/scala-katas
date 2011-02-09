package net.emilsebastian.kata.bowling

import org.scalatest.FeatureSpec
import collection.mutable.ListBuffer
import org.scalatest.matchers.MustMatchers

/**
 * Specification for {@link ScoreCalculator}.
 */

class ScoreCalculatorSpec extends FeatureSpec with MustMatchers {

  feature("The score can be calculated.") {

    scenario("A gutter game (all zeroes) is played") {

      var frames = ListBuffer[BowlingFrame]()

      do {
        frames += new BowlingFrame(0, 0)

      } while (frames.size < 10)

      ScoreCalculator.calculate(frames.toList) must be === 0
    }

    scenario("No spares or strikes") {

      var frames = ListBuffer[BowlingFrame]()

      do {
        frames += new BowlingFrame(1, 1)

      } while (frames.size < 10)

      ScoreCalculator.calculate(frames.toList) must be === 20
    }

    scenario("First frame is a spare") {

      var frames = ListBuffer[BowlingFrame](
        new BowlingFrame(9, 1)
      )

      do {
        frames += new BowlingFrame(1, 1)

      } while (frames.size < 10)

      ScoreCalculator.calculate(frames.toList) must be === 29
    }

    scenario("Last frame is a spare") {

      var frames = ListBuffer[BowlingFrame]()

      do {
        frames += new BowlingFrame(1, 1)

      } while (frames.size < 9)

      frames += new BowlingFrame(2, 8, 1)

      ScoreCalculator.calculate(frames.toList) must be === 29
    }

    scenario("First frame is a strike") {

      var frames = ListBuffer[BowlingFrame](
        new BowlingFrame(10)
      )

      do {
        frames += new BowlingFrame(1, 1)

      } while (frames.size < 10)

      ScoreCalculator.calculate(frames.toList) must be === 30
    }

    scenario("Last frame is a strike") {

      var frames = ListBuffer[BowlingFrame]()

      do {
        frames += new BowlingFrame(1, 1)

      } while (frames.size < 9)

      frames += new BowlingFrame(10, 1, 1)

      ScoreCalculator.calculate(frames.toList) must be === 30
    }

    scenario("Perfect game (only strikes)") {

      var frames = ListBuffer[BowlingFrame]()

      do {
        frames += new BowlingFrame(10)

      } while (frames.size < 9)

      frames += new BowlingFrame(10, 10, 10)

      ScoreCalculator.calculate(frames.toList) must be === 300
    }

  }

}