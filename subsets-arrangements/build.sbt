name := "subsets-arrangements"

version := "0.1"

scalaVersion := "2.10.4"

scalaSource in Compile <<= baseDirectory

scalaSource in Test <<= baseDirectory

resourceDirectory <<= baseDirectory

unmanagedSourceDirectories in Compile <<= Seq(scalaSource in Compile).join

unmanagedSourceDirectories in Test <<= Seq(scalaSource in Test).join

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "org.dupontmanual" %% "dm-image" % "0.9-SNAPSHOT"
)

initialCommands in console := """import SubsetsArrangements._;"""

scalacOptions ++= Seq("-deprecation", "-feature")

traceLevel in Test := -1
