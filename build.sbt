import Dependencies._

ThisBuild / name := "data-has"

ThisBuild / organization := "io.github.anakos"

ThisBuild / scalaVersion := "2.13.1"

ThisBuild / homepage := Some(url("https://github.com/anakos/data-has"))

ThisBuild / scmInfo := Some(ScmInfo(url("https://github.com/anakos/data-has"), "git@github.com:anakos/data-has.git"))

ThisBuild / developers := List(Developer("anakos", "Alexander Nakos", "anakos@gmail.com", url("https://github.com/anakos")))

ThisBuild / licenses += ("MIT", url("https://github.com/anakos/data-has/blob/master/LICENSE"))

ThisBuild / publishMavenStyle := true

// Add sonatype repository settings
ThisBuild / publishTo := sonatypePublishToBundle.value

libraryDependencies ++= List(
   cats.core,
   cats.effect,
)
