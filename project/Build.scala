import sbt._
import Keys._

object MyBuild extends Build {
  lazy val myProject = Project("study-attributeFactory", file(".")) settings(
    libraryDependencies ++= Seq(
      "org.apache.solr" % "solr-solrj" % "3.5.0",
      "org.apache.solr" % "solr-core" % "3.5.0",
      "org.apache.lucene" % "lucene-core" % "3.5.0",
      "org.slf4j" % "slf4j-api" % "1.6.2",
      "org.slf4j" % "slf4j-jdk14" % "1.6.2",
      "org.scalatest" %% "scalatest" % "1.6.1" % "test"
    ),
    organization := "",
    scalaVersion := "2.9.1"
  )
}