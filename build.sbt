name := "csearching"

organization := "cc.acs"

version := "0.1-SNAPSHOT"

scalaVersion := "2.9.2"

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.9.2"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.0.0-M3"
            
libraryDependencies += "net.liftweb" % "lift-json_2.9.1" % "2.5-M1"

libraryDependencies += "net.liftweb" % "lift-json-ext_2.9.1" % "2.5-M1"

libraryDependencies += "org.specs2" %% "specs2" % "latest.release" % "test" 

// libraryDependencies += "net.liftweb" % "lift-json-scalaz_2.9.1" % "2.5-M1"

initialCommands in console := """
  println("Commence hacking...")
"""

// set Ivy logging to be at the highest level
ivyLoggingLevel := UpdateLogging.Full

// set the prompt (for this build) to include the project id.
shellPrompt in ThisBuild := { state => Project.extract(state).currentRef.project + "> " }

// only use a single thread for building
parallelExecution := true

// only show warnings and errors on the screen for all tasks (the default is Info)
logLevel := Level.Info

// only store messages at info and above (the default is Debug)
//   this is the logging level for replaying logging with 'last'
persistLogLevel := Level.Debug

// only show stack traces up to the first sbt stack frame
// traceLevel := 10
traceLevel := 0

