import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "todolist"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
        // GroupID, ArtifactID, Version - genaue Angaben können dem default maven repository unter http://mvnrepository.com entnommen werden
        // Zudem wird auch das scala-tools repository durchsucht unter https://oss.sonatype.org/content/groups/scala-tools/
    	"com.google.code.gson" % "gson" % "2.2.2" 
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
        // Muss nur defeniert werden wenn die Abhängigkeit(lib) nicht im default maven oder scala-tools repository auftaucht
        resolvers += "Scala-Tools Maven2 Snapshots Repository" at "https://oss.sonatype.org/content/groups/scala-tools/"
    )

}
