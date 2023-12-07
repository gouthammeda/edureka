package utilities

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object sparkconfig {
  //configuring spark properties:
  //spark properties control most application settings and are configured separately for
  // each application properties can be set in spark conf passed to your spark context.
  val conf = new SparkConf()
    .setMaster("local[1]")
    .setAppName("")
  val sc = new SparkContext(conf)
  sc.setLogLevel("ERROR")

  val spark = SparkSession
    .builder
    .appName("input")
    .master("local")
    .getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")

}
