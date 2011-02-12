package net.emilsebastian.kata.pascal

/**
 * A Pascal's Triangle generator.
 *
 * @author emilsebastian
 */
class PascalsTriangleGenerator {

  /**
   * Returns a Pascal's Triangle represented as a list of rows.
   *
   * @param n number of rows to generate
   * @returns a list of rows
   */
  def generate(n: Int): List[List[Int]] = n match {

    case 0 => Nil

    case 1 => List(List(1))

    case _ =>
      val rows = generate(n - 1)
      rows :+ generateNextRow(rows.last)
  }

  /**
   * Returns the next row, given the current row.
   *
   * @param row current row
   * @returns a row
   */
  def generateNextRow(row: List[Int]): List[Int] = {

    1 :: row.foldLeft((List[Int](), 0))((result, item) => {
      (result._2 + item :: result._1, item)
    })._1
  }

}