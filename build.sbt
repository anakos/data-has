import Dependencies._

ThisBuild / name := "data-has"

ThisBuild / organization := "io.github.anakos"

ThisBuild / scalaVersion := "2.13.1"

libraryDependencies ++= List(
   cats.core,
   cats.effect,
)
