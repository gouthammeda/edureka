package SparkDataframe

import utilities.caseclassHelper.person
import org.apache.spark.sql.functions._
import utilities.sparkconfig.spark
import spark.implicits._


/* Created by gouthamkumarreddymeda on 4/16/23 */
object SparkHiveIntegration {
  def main(args:Array[String]) {
    val data = Seq(person("Harry", 24, "Manhattan"), person("Marry", 21, "NewYork"), person("Ram", 23, "NewDelhi"))
    val df = data.toDF()
    val df1 = df.withColumn("Department", lit("Finance")).toDF()
    df1.write.parquet(args(0))
    val sparkhivedf = spark.sql("select * from gowthambha87edu.sparkhive")
    sparkhivedf.show
  }
}
