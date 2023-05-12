package SparkRDD

//word count
import org.apache.spark.{SparkConf, SparkContext}
/* Created by gouthamkumarreddymeda on 4/15/23 */
object WordCount {
  def main(args: Array[String]) {
    val logFile = args(0)
    val sparkConf = new SparkConf().setAppName("Spark word count").setMaster("local")
    val sc = new SparkContext(sparkConf)
    sc.setLogLevel("ERROR")
    val file = sc.textFile(logFile)
    val counts = file.flatMap(_.split(" ")).map(x => (x, 1)).reduceByKey(_ + _)
    //counts.collect().foreach(println)
    counts.saveAsTextFile(args(1))
  }
}

//spark-submit \
//--class ScalaWordCount \
//--master yarn \
///home/gowthambha87edu/scalawordcount/target/scala-2.11/scalawordcount_2.11-1.0.jar
