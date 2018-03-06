import sbt._

object Dependencies {
  val catsCoreVersion = "0.9.0"
  val fs2CatsVersion = "0.3.0"
  val fs2IOVersion = "0.9.7"
  val circeVersion = "0.8.0"
  val logbackClassicVersion = "1.2.3"
  val mongoScalaVersion = "2.1.0"
  val mongoJavaVersion = "3.4.2"
  val awsSdkVersion = "1.11.239"
  val typesafeConfigVersion = "1.3.2"

  // Compile Dependencies
  val catsCore: ModuleID = "org.typelevel" %% "cats-core" % catsCoreVersion
  val fs2Cats: ModuleID = "co.fs2" %% "fs2-cats" % fs2CatsVersion
  val fs2IO: ModuleID = "co.fs2" %% "fs2-io" % fs2IOVersion

  val circeCore: ModuleID = "io.circe" %% "circe-core" % circeVersion
  val circeGeneric: ModuleID = "io.circe" %% "circe-generic" % circeVersion
  val circeParser: ModuleID = "io.circe" %% "circe-parser" % circeVersion

  val typesafeConfig: ModuleID = "com.typesafe" % "config" % typesafeConfigVersion

  val logbackCore: ModuleID = "ch.qos.logback" % "logback-core" % logbackClassicVersion
  val logbackClassic: ModuleID = "ch.qos.logback" % "logback-classic" % logbackClassicVersion

  val awsSnsSdk: ModuleID = "com.amazonaws" % "aws-java-sdk-sns" % awsSdkVersion

  // Module dependencies
  lazy val commonDependencies: Seq[ModuleID] = Seq(
    catsCore,
    fs2Cats,
    fs2IO,
    logbackCore,
    logbackClassic,
    circeCore,
    circeGeneric,
    circeParser,
    typesafeConfig,
    awsSnsSdk
  )

}
