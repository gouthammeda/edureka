package SparkRDD

//word count
import org.apache.spark.{SparkConf, SparkContext}
/* Created by gouthamkumarreddymeda on 4/15/23 */
object WordCount {
  def main(args: Array[String]) {
    val logFile = "/user/gowthambha87edu/sample.txt"
    val sparkConf = new SparkConf().setAppName("Spark word count")
    val sc = new SparkContext(sparkConf)
    val file = sc.textFile(logFile)
    val counts = file.flatMap(_.split(" ")).map(x => (x, 1)).reduceByKey(_ + _)
    counts.saveAsTextFile("/user/gowthambha87edu/sampleOutput/SparkScalaWordcount/output.txt")
  }
}

//spark-submit \
//--class ScalaWordCount \
//--master yarn \
///home/gowthambha87edu/scalawordcount/target/scala-2.11/scalawordcount_2.11-1.0.jar
