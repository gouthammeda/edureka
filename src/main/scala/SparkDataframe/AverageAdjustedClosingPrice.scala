package SparkDataframe
import utilities.sparkconfig._
import org.apache.spark.sql.functions._

//calculate Average adjusted closing price for aaon stock per month in descending order of year and month
//performing sample use case with dataframe

/* Created by gouthamkumarreddymeda on 4/17/23 */
object AverageAdjustedClosingPrice {
    def main(args:Array[String]) {
      //1.Read the file to create dataframe
      val aaonDf = spark.read.option("header", true).option("inferSchema", true).csv(args(0))
      //2.Extract year from date
      //year - function to extract year from date
      val aaonYear = aaonDf.withColumn("Year", year(col("Date")))
      //3.select month from date
      val aaonyearmonth = aaonDf.withColumn("Year", year(col("Date"))).withColumn("Month", month(col("Date")))
      //4.Grouping on year and month, aggregation (average) of Adj close
      val aaongroup = aaonyearmonth.groupBy("Year", "Month").agg(avg(col("AdjClose")).as("AverageAdjustedPr"))
      val aaonround = aaongroup.withColumn("AvgAdgPr", round(col("AverageAdjustedPr"), 1))
      //5.sort the data in descending order of month and year.
      val aaonsorted = aaonround.orderBy(col("Year").desc, col("Month").desc)

      aaonDf.withColumn("Year", year(col("Date")))
        .withColumn("Month", month(col("Date")))
        .groupBy("Year", "Month")
        .agg(avg(col("AdjClose")).as("AverageAdjustedPr"))
        .withColumn("AvgAdgPr", round(col("AverageAdjustedPr"), 1))
        .orderBy(col("Year").desc, col("Month").desc)
        .show
    }

}
