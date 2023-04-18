package SparkDataframe

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._


/* Created by gouthamkumarreddymeda on 4/17/23 */
object Input {
  def main(args:Array[String]) {
    val spark = SparkSession
      .builder
      .appName("input")
      .master("local")
      .getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    val peopleDF = spark.read.json(args(0))
    peopleDF.show
    val personGt30 = peopleDF.filter(col("age").gt(30))
    personGt30.show
    val peopleSalary = personGt30.withColumn("salary", col("age") * 100)
    peopleSalary.show()
    val peopleSalaryWithExpression = personGt30.withColumn("salary", expr("age * 100"))
    peopleSalaryWithExpression.show()
    val peoplewithDepartment = peopleSalary.withColumn("Department", lit("Finance"))
    peoplewithDepartment.show

    val empDf = spark.read.option("header",true).csv(args(1))
    empDf.show()
    //by default it shows 20 characters in the column.
    //empDf.show(20,false)
    empDf.printSchema

    //using json as input
    val nested = spark.read.json(args(2))
    nested.printSchema
    nested.select("IOT data.DeviceType", "timestamp").show

    val multiline = spark.read.option("multiline", "true").csv("/user/gowthambha87edu/sparkDF/multiline.json")
    multiline.show

  }
}
