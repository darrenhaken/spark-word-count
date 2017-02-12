//import org.apache.spark.{SparkContext, SparkConf}

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SparkWordCount {
  def main(args: Array[String]): Unit = {
    //    System.setProperty("hadoop.home.dir", "D:")
    val logFile = "/Users/dhaken/Workarea/haken/spark-word-count/words.txt"

    val conf = new SparkConf()
      .setAppName("SparkWordCount")
      .setMaster("local[*]")

    val sc = new SparkContext(conf)
    val textFile = sc.textFile(logFile)
    val splits = textFile.flatMap(line => line.split(" ")).map(word => (word, 1))
    val counts = splits.reduceByKey((x, y) => x + y)

    splits.saveAsTextFile("splits.txt")
    counts.saveAsTextFile("counts.txt")
  }
}
