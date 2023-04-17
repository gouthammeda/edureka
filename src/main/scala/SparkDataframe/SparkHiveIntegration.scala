package SparkDataframe

import org.apache.spark
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

/* Created by gouthamkumarreddymeda on 4/16/23 */
object SparkHiveIntegration {

  def main(args:Array[String]) {
    val spark = SparkSession
      .builder
      .appName("dataframe")
      .master(args(0))
      .getOrCreate()
    import spark.implicits._

    val data = Seq(Elp("Harry", 24, "Manhattan"), Elp("Marry", 21, "NewYork"), Elp("Ram", 23, "NewDelhi"))
    val df = data.toDF()
    val df1 = df.withColumn("Department", lit("Finance")).toDF()
    df1.write.parquet("/user/gowthambha87edu/sparkhive")

    val sparkhivedf = spark.sql("select * from gowthambha87edu.sparkhive")
    sparkhivedf.show
  }
}
