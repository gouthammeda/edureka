package SparkRDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, desc, to_date, unix_timestamp}

/* Created by gouthamkumarreddymeda on 11/19/22 */
object LogAnalyser {
  def main(args:Array[String])={
    val spark = SparkSession
      .builder
      .appName("log Analyser")
      .master(args(0))
      .getOrCreate()
    import spark.implicits._
    val sample = spark.read.text(args(1))
    val df = sample.map(_.getString(0).split(" ")).map(d => (d(0), d(3).replace("[", ""), d(5), d(6), d(8))).toDF("remote_host", "timestamp", "request_type", "url", "status_code")
    //df.show()
    df.filter($"status_code"==="204").count

    val filterCond = df.columns.map(x => col(x).isNull).reduce(_ || _)
    df.filter(filterCond).count
    df.na.fill("404",Seq("status_code"))

    val df3 = df.withColumn("Date", to_date(unix_timestamp(df.col("timestamp"), "dd/MMM/yyyy").cast("timestamp")))
    df3.groupBy("status_code").count().sort(desc("count")).show()

  }

}
