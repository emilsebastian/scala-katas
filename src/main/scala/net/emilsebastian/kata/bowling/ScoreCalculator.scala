package net.emilsebastian.kata.bowling

/**
 * Utility for calculating the score of a game of bowling.
 *
 * @author emilsebastian
 */
object ScoreCalculator {

  def calculate(frames: List[BowlingFrame]): Int = {

    if (frames.isEmpty) {
      return 0;
    }

    var score = 0;

    val frame = frames.head
    val remainingFrames = frames.tail

    if (frame.isStrike) {
      score += calculateStrikeScore(frame, remainingFrames)

    } else {

      score += frame.firstRoll + frame.secondRoll

      if (frame.isSpare) {

        if (remainingFrames.isEmpty) {
          // add the score from the last bonus roll if this was the last frame played
          score += frame.thirdRoll

        } else {
          // add the score from the first roll in the subsequent frame
          score += remainingFrames.head.firstRoll
        }
      }

    }

    score + calculate(remainingFrames)
  }

  /**
   * Calculates the sum of the frame's score and the score of the two subsequent rolls.
   */
  private def calculateStrikeScore(frame: BowlingFrame, remainingFrames: List[BowlingFrame]): Int = {

    var score = frame.firstRoll

    if (remainingFrames.isEmpty) {
      // this was the last frame, add the score from the two bonus rolls
      score += frame.secondRoll + frame.thirdRoll

    } else {

      val nextFrame = remainingFrames.head

      score += nextFrame.firstRoll

      if (!nextFrame.isStrike || remainingFrames.tail.isEmpty) {
        score += nextFrame.secondRoll

      } else {
        score += remainingFrames.tail.head.firstRoll
      }
    }

    score
  }

}