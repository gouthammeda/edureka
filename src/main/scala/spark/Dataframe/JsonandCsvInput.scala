package spark.Dataframe

import org.apache.spark.sql.functions._
import utilities.sparkconfig.spark
import spark.implicits._

/* Created by gouthamkumarreddymeda on 4/17/23 */
object JsonandCsvInput {
  def main(args:Array[String]) {
    val peopleDF = spark.read.json(args(0))
    peopleDF.show()
    peopleDF.select("name").show()
    peopleDF.select($"name",$"age"+1).show()
    peopleDF.filter($"age" > 21).show()
    peopleDF.groupBy("age").count.show()

    val personGt30 = peopleDF.filter(col("age").gt(30))
    personGt30.show()
    val peopleSalary = personGt30.withColumn("salary", col("age") * 100)
    peopleSalary.show()
    val peopleSalaryWithExpression = personGt30.withColumn("salary", expr("age * 100"))
    peopleSalaryWithExpression.show()
    val peoplewithDepartment = peopleSalary.withColumn("Department", lit("Finance"))
    peoplewithDepartment.show()

    //csv input
    val empDf = spark.read.option("header",value = true).csv(args(1))
    empDf.show()
    //by default it shows 20 characters in the column.
    //empDf.show(20,false)
    empDf.printSchema
  }
}
