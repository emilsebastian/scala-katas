import sbt._

class ScalaKatasProject(info: ProjectInfo) extends DefaultProject(info) {

    val scalatest = "org.scalatest" % "scalatest" % "1.2" % "test"

}
