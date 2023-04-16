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

    case class Elp(name: String, age: Int, location: String)
    val inputdata = Seq(Elp("Harry", 24, "Manhattan"), Elp("Marry", 21, "NewYork"), Elp("Ram", 23, "NewDelhi"))
//    val df = inputdata.toDF()
//    val df1 = df.withColumn("Department", lit("Finance")).toDF()
//    df1.write.parquet("/user/gowthambha87edu/sparkhive")

    //create external table gowthambha87edu.sparkhive(name STRING,age INT,address STRING,department STRING)
    //STORED AS PARQUET
    //LOCATION '/user/gowthambha87edu/sparkhive/';
    //select * from gowthambha87edu.sparkhive;

    val sparkhivedf = spark.sql("select * from gowthambha87edu.sparkhive")
    sparkhivedf.show
  }
}
