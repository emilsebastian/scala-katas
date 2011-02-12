package net.emilsebastian.kata.pascal

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

/**
 * Specification for {@link PascalsTriangleGenerator}.
 */
class PascalsTriangleGeneratorSpec extends FlatSpec with ShouldMatchers {

  val generator = new PascalsTriangleGenerator()

  "Row generator" should "generate a correct first row" in {
    generator.generateNextRow(List()) should equal(List(1))
  }

  it should "generate a correct second row" in {
    generator.generateNextRow(List(1)) should equal(List(1, 1))
  }

  it should "generate a correct third row" in {
    generator.generateNextRow(List(1, 1)) should equal(List(1, 2, 1))
  }

  it should "generate a correct fourth row" in {
    generator.generateNextRow(List(1, 2, 1)) should equal(List(1, 3, 3, 1))
  }

  it should "generate a correct fifth row" in {
    generator.generateNextRow(List(1, 3, 3, 1)) should equal(List(1, 4, 6, 4, 1))
  }

  "Pascal's Triangle generator" should "generate a correct triangle with six levels" in {
    generator.generate(6) should equal(List(
      List(1),
      List(1, 1),
      List(1, 2, 1),
      List(1, 3, 3, 1),
      List(1, 4, 6, 4, 1),
      List(1, 5, 10, 10, 5, 1)
    ))
  }

}