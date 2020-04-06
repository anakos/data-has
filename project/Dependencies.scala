import sbt._

object Dependencies {
  object cats {
    val core   = "org.typelevel" %% s"cats-core"   % "2.1.1"
    val effect = "org.typelevel" %% s"cats-effect" % "2.1.2"
  }
}
