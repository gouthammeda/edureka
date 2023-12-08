package spark.Dataframe

import utilities.sparkconfig.spark
import org.apache.spark.sql.functions._
import spark.implicits._
import utilities.caseclassHelper.{Age, Employ}


/* Created by gouthamkumarreddymeda on 4/17/23 */
object AggandJoins {

  def main(args: Array[String]) {
    val empData = spark.read.option("header", value = true).option("inferSchema", value = true).csv(args(0))
    empData.printSchema

    //aggregations
    empData.withColumnRenamed("salary", "money").show
    empData.withColumn("lenLastName", length(col("last_name"))).show
    empData.select(max(length(col("last_name")))).show

    empData.select("first_name").show
    empData.select($"first_name", $"salary" + 1).show
    empData.filter($"salary" > 3000).show()
    empData.groupBy("age").count.show()

    //joins
//    val df1 = spark.sql("select * from gowthambha87edu.sparkhive")
//    df1.show

    val df1 = Seq(Employ("goutham",31,"it"), Employ("ravi",25, "hr"),Employ("kiran",24,"it")).toDF()
     df1.show
    val inp = Seq(Age(24, 2400), Age(25, 2500))
    val df2 = inp.toDF()
    val output = df1.join(df2, Seq("age"))
    output.show()
    val out = df1.join(df2, df1.col("age") === df2.col("age"))
    out.show()

  }
}