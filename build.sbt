import Dependencies._

ThisBuild / name := "data-has"

ThisBuild / organization := "smf"

ThisBuild / scalaVersion := "2.13.1"

libraryDependencies ++= List(
   cats.core,
   cats.effect,
)
