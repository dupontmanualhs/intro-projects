name := "snake"

version := "0.1"

scalaVersion := "2.10.4"

fork := true

scalaSource in Compile <<= baseDirectory

scalaSource in Test <<= baseDirectory

resourceDirectory <<= baseDirectory

unmanagedSourceDirectories in Compile <<= Seq(scalaSource in Compile).join

unmanagedSourceDirectories in Test <<= Seq(scalaSource in Test).join

unmanagedJars in Compile += Attributed.blank(
    file(scala.util.Properties.javaHome) / "lib" / "jfxrt.jar")


resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "org.dupontmanual" %% "dm-image" % "0.9-SNAPSHOT"
)

scalacOptions ++= Seq("-deprecation", "-feature")

initialCommands in console := """import org.dupontmanual.image._; org.dupontmanual.image.initialize(); import Snake._;"""

traceLevel in Test := -1
