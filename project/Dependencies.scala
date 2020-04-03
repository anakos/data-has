import sbt._

object Dependencies {
  object cats {
    def mkModule(name: String) =
      "org.typelevel" %% s"cats-${name}" % "2.1.1" withSources()

    val core   = mkModule("core")
    val effect = mkModule("effect")
  }
}
