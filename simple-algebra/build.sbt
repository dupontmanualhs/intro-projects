name := "simple-algebra"

version := "0.1"

scalaVersion := "2.10.2"

scalaSource in Compile <<= baseDirectory

scalaSource in Test <<= baseDirectory

resourceDirectory <<= baseDirectory

unmanagedSourceDirectories in Compile <<= Seq(scalaSource in Compile).join

unmanagedSourceDirectories in Test <<= Seq(scalaSource in Test).join

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.0.M8"
)

scalacOptions ++= Seq("-deprecation", "-feature")
