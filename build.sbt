name := "umka"

version := "1.0"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
 "com.turn" % "ttorrent" % "1.4",
 "org" % "jaudiotagger" % "2.0.3"
)

resolvers ++= Seq(
  "jboss-3rd-party-releases" at "https://repository.jboss.org/nexus/content/repositories/thirdparty-releases/",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)


