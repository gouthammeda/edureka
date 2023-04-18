package SparkDataframe

import org.apache.spark
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

/* Created by gouthamkumarreddymeda on 4/17/23 */
object sparksql {
  def main(args: Array[String]) {
    val spark = SparkSession
      .builder
      .appName("dataframe spark sql")
      .master("local")
      .getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    //using spark sql
    val people = spark.read.json(args(0))
    people.createOrReplaceTempView("people table")
    val peopleGt30 = spark.sql("select * from people table where age > 30")
    peopleGt30.show
    people.filter(col("age").gt(30)).show

  }
}
