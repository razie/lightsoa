import sbt._
import Keys._
import java.io.File

object V {
  val version      = "0.6.3-SNAPSHOT"
  val scalaVersion = "2.9.1"
  val organization = "com.razie"

  def snap = (if (V.version endsWith "-SNAPSHOT") "-SNAPSHOT" else "")

  def RAZBASEVER = "0.6.3" + snap
}

object MyBuild extends Build {

  def scalatest  = "org.scalatest"  % "scalatest_2.9.1" % "1.6.1"
  def junit      = "junit"          % "junit"           % "4.5" //     % "test->default"
  def json       = "org.json"       % "json"            % "20090211"
  def slf4jApi   = "org.slf4j"      % "slf4j-api"       % "1.6.1"
  def logback    = "ch.qos.logback" % "logback-classic" % "0.9.28"
  
  def razBase    = "com.razie" %% "razbase"         % V.RAZBASEVER
  def w20        = "com.razie" %% "20widgets"       % V.RAZBASEVER

  lazy val root = Project(id="lightsoa",    base=file("."),
                          settings = defaultSettings ++ Seq()
                  ) aggregate (core) dependsOn (core)

  lazy val core = Project(id="lightsoa-core", base=file("core"),
                          settings = defaultSettings ++ 
                          Seq(libraryDependencies ++= Seq(scalatest, junit, json, razBase, w20))
                  )

  def defaultSettings = baseSettings ++ Seq()

  def baseSettings = Defaults.defaultSettings ++ Seq (
    scalaVersion         := V.scalaVersion,
    version              := V.version,
    organization         := V.organization,
    organizationName     := "Razie's Pub",
    organizationHomepage := Some(url("http://www.razie.com")),

    publishTo <<= version { (v: String) =>
      if(v endsWith "-SNAPSHOT")
        Some ("Sonatype" at "https://oss.sonatype.org/content/repositories/snapshots/")
      else
        Some ("Sonatype" at "https://oss.sonatype.org/content/repositories/releases/")
    } ,

    resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                      "releases"  at "http://oss.sonatype.org/content/repositories/releases")
    )

}


