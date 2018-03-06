import Dependencies._

name := "sns-mobile-push-scala"

lazy val root = (project in file("."))
  .settings(
    Commons.settings,
    libraryDependencies ++= commonDependencies
  )
