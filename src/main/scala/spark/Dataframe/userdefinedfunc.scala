package spark.Dataframe

import utilities.sparkconfig.spark
import org.apache.spark.sql.functions._

/* Created by gouthamkumarreddymeda on 4/16/23 */
object userdefinedfunc {
  def main(args: Array[String]) {
    val temp = spark.read.json(args(0))
    val CtoF = udf((degCel: Double) => (degCel * 9.0 / 5.0) + 32)

    temp.withColumn("avgHighF", CtoF(col("avgHigh")))
      .withColumn("avgLowF", CtoF(col("avgLow")))
      .show()
    temp.withColumn("avgHighF", round(CtoF(col("avgHigh")), 1))
      .withColumn("avgLowF", round(CtoF(col("avgLow")), 1))
      .drop("avgHigh", "avgLow")
      .show

    val df = spark.read.json(args(1))
    df.createOrReplaceTempView("people")
    spark.udf.register("myUpper", (input: String) => input.toUpperCase)
    spark.sql("select myUpper(name) from people where age>20").show()

  }
}
