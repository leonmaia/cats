import sbt.Keys._
import sbt._

object Cats extends Build {

  lazy val cats = Project(
    id = "cats",
    base = file("."),
    settings = Project.defaultSettings ++ sharedSettings).settings(
    name := "cats",
    mainClass in(Compile, run) := Some("com.lm.cats.HttpServer")

  )

  val sharedSettings = Seq(
    version := "1.0",
    organization := "com.globo",
    libraryDependencies ++= coreDependencies,
    javacOptions in(Compile, compile) ++= Seq("-source", "1.8", "-target", "1.8", "-g:lines"),
    crossPaths := false,
    autoScalaLibrary := false
  )

  lazy val coreDependencies = Seq(
    "com.twitter" %% "finagle-http" % "6.33.0",
    "com.fasterxml.jackson.core" % "jackson-core" % "2.7.1",
    "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.1",
    "com.fasterxml.jackson.core" % "jackson-annotations" % "2.7.1"
  )
}