ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := "2.13.8"

val akkaHttpVersion = "10.2.9"
val akkaVersion = "2.6.19"
val configVersion = "1.4.2"
val macWireVersion = "2.5.7"
val scalaTestVersion = "3.2.12"
val catsVersion = "2.7.0"

lazy val root = (project in file("."))
  .settings(
    name := "hn-stories",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream" % akkaVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe" % "config" % configVersion,
      "com.softwaremill.macwire" %% "macrosakka" % macWireVersion % "provided",
      "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion,
      "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion,
      "org.scalatest" %% "scalatest" % scalaTestVersion,
      "org.typelevel" %% "cats-core" % catsVersion
    )
  )
