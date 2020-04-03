import Dependencies._

ThisBuild / name := "data-has"

ThisBuild / organization := "com.gitlab.anakos"

ThisBuild / scalaVersion := "2.13.1"

libraryDependencies ++= List(
   cats.core,
   cats.effect,
)
