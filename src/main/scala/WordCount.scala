//import org.apache.spark.{SparkContext, SparkConf}

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object WordCount {
  def main(args: Array[String]): Unit = {
    val logFile = "./words.txt"

    val conf = new SparkConf()
      .setAppName("SparkWordCount")
      .setMaster("local[*]")

    val sc = new SparkContext(conf)
    val lines = sc.textFile(logFile)
    val words = lines.flatMap(line => line.split(" ")).map(word => (word, 1))

    val wordCount = words.map(word => (word, 1)).reduceByKey(_ + _)

    wordCount.saveAsTextFile("words.count")
  }
}
