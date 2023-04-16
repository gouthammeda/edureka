package SparkDataframe

import org.apache.spark
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

/* Created by gouthamkumarreddymeda on 4/16/23 */
object userdefinedfunc {
  val spark = SparkSession
    .builder
    .appName("dataframe")
    .master("local")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  //user defined functions
  // avgHigh avgLow City
  // {"avgHigh":8.7, "avgLow":0.6,"city":"Montreal"}
  // {"avgHigh":11.1,"avgLow":1.4,"city":"Ottawa"}
  // {"avgHigh":10.5,"avgLow":-2.4,"city":"Calgary"}

  val temp = spark.read.json("/user/gowthambha87edu/sparkDF/temp.json")
  val CtoF = udf((degCel: Double) => ((degCel * 9.0 / 5.0) + 32))
  temp.withColumn("avgHighF", CtoF(col("avgHigh"))).withColumn("avgLowF", CtoF(col("avgLow"))).show()
  temp.withColumn("avgHighF", round(CtoF(col("avgHigh")), 1)).withColumn("avgLowF", round(CtoF(col("avgLow")), 1)).drop("avgHigh", "avgLow").show
  temp.withColumn("avgHighF", round(CtoF(col("avgHigh")), 1))
  //round (((8.7 * 9.0 / 5.0) + 32), 1)

  val df = spark.read.json("/user/gowthambha87edu/sparkDF/people.json")
  df.registerTempTable("people")
  spark.udf.register("myUpper", (input: String) => input.toUpperCase)
  spark.sql("select myUpper(name) from people where age>20").show()

}
