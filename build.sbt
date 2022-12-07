name := "spark-sql-antlr-grammar"

version := "0.1"


scalaVersion := "2.13.8"

scalacOptions += "-language:postfixOps"

scalacOptions += "-language:implicitConversions"

scalacOptions += "-deprecation"

scalacOptions += "-DshowSuppressedErrors=true"

// tests are not thread safe

enablePlugins(Antlr4Plugin)

libraryDependencies += "jline" % "jline" % "2.11"
libraryDependencies +=  "org.antlr" % "antlr4" % "4.9.3"

sourcesInBase := false

Antlr4 / antlr4GenListener := false
Antlr4 / antlr4GenVisitor := true
Antlr4 / antlr4TreatWarningsAsErrors := true
Antlr4 / antlr4Version := "4.9.3"
Antlr4 / antlr4PackageName := Some("com.spark.sql.parser")