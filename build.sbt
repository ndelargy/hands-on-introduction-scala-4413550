lazy val root = (project in file(".")).settings(
  name := "hands-on-scala",
  scalaVersion := "3.3.3",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % "test"
)
