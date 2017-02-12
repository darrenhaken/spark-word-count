name := "word-count"

version := "1.0"

scalaVersion := "2.11.8"

val sparkVersion = "2.1.0"

//Override Scala Version to the above version which is compatible with Spark
ivyScala := ivyScala.value.map {_.copy(overrideScalaVersion = true)}

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.11" % sparkVersion exclude("org.apache.hadoop", "hadoop-yarn-server-web-proxy"),
  "org.apache.spark" % "spark-sql_2.11" % sparkVersion exclude("org.apache.hadoop", "hadoop-yarn-server-web-proxy")
  //  "org.apache.hadoop" % "hadoop-common" % "2.7.3" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy")
  //  "org.apache.spark" % "spark-sql_2.11" % "1.6.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  //  "org.apache.spark" % "spark-hive_2.11" % "1.6.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  //  "org.apache.spark" % "spark-yarn_2.11" % "1.6.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy")
)