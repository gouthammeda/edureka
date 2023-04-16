package SparkDataframe
// spark sql has following libraries:
// 1.Data Source API
// 2.Data Frame API
// 3.Interpreter & Optimizer
// 4.SQL service

import org.apache.spark.SparkContext._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

/* Created by gouthamkumarreddymeda on 4/15/23 */
case class Age(id:Int, Salary:Int)
object dataframes {
  def main(args:Array[String]):Unit= {

    val spark = SparkSession
      .builder
      .appName("dataframe")
      .master("local")
      .getOrCreate()
    import spark.implicits._
    spark.sparkContext.setLogLevel("ERROR")

    val peopleDF = spark.read.json ("/user/gowthambha87edu/sparkDF/people.json")
    peopleDF.show

    val personGt30 = peopleDF.filter (col ("age").gt (30) )
    personGt30.show

    val peopleSalary = personGt30.withColumn("salary", col ("age") * 100)
    peopleSalary.show ()

    val peopleSalaryWithExpression = personGt30.withColumn ("salary", expr ("age * 100") )
    peopleSalaryWithExpression.show ()

    val peoplewithDepartment = peopleSalary.withColumn ("Department", lit ("Finance") )
    peoplewithDepartment.show

    val empDf = spark.read.option ("header", true).csv ("/user/gowthambha87edu/sparkDF/emp.csv")
    empDf.show ()
    //by default it shows 20 characters in the column.
    //empDf.show(20,false)
    empDf.printSchema

    //using csv as input

    val empData = spark.read.option ("header", true).option ("inferSchema", true).csv ("/user/gowthambha87edu/sparkDF/emp.csv")
    empDf.printSchema

    //empData.withCoulmnRenamed("salary", "money").show
    empData.withColumn ("lenLastName", length (col ("last_name") ) ).show
    empData.select (max(length(col("last_name")))).show

    empData.select ("first_name").show
    empData.select ($"first_name", $"salary" + 1).show
    empData.filter ($"salary" > 3000).show ()
    empData.groupBy ("age").count.show ()

    //using json as input
    val nested = spark.read.json ("/user/gowthambha87edu/sparkDF/nested.json")
    nested.printSchema
    nested.select ("IOT data.DeviceType", "timestamp").show
    val multiline = spark.read.option ("multiline", "true").csv ("/user/gowthambha87edu/sparkDF/multiline.json")
    multiline.show

    //calculate Average adjusted closing price for aaon stock per month in descending order of year and month
    //performing sample use case with dataframe

    // Date,open,High,Low,Close,Volume,AdjClose
    // 2015-12-31 00:00:00,23.57,23.84,23.19,23.21,211100,23.03
    // 2015-12-30 00:00:00,23.5,23.84,23.5,23.67,131500,23.48
    // 2015-12-29 00:00:00,23.62,23.70,23.29,23.52,220900,23.33
    // 2015-11-29 00:00:00,23.60,23.80,23.30,23.42,220901,23.90

    //1.Read the file to create dataframe
    val aaonDf = spark.read.option ("header", true).option ("inferSchema", true).csv ("/user/gowthambha87edu/sparkDF/aaon.csv")
    //2.Extract year from date
    //year - function to extract year from date
    val aaonYear = aaonDf.withColumn ("Year", year (col ("Date") ) )
    //3.select month from date
    val aaonyearmonth = aaonDf.withColumn ("Year", year (col ("Date") ) ).withColumn ("Month", month (col ("Date") ) )
    //4.Grouping on year and month, aggregation (average) of Adj close
    val aaongroup = aaonyearmonth.groupBy ("Year", "Month").agg (avg (col ("AdjClose") ).as ("AverageAdjustedPr") )
    val aaonround = aaongroup.withColumn ("AvgAdgPr", round (col ("AverageAdjustedPr"), 1) )
    //5.sort the data in descending order of month and year.
    val aaonsorted = aaonround.orderBy (col ("Year").desc, col ("Month").desc)
    aaonDf.withColumn ("Year", year (col ("Date") ) ).withColumn ("Month", month (col ("Date") ) ).groupBy ("Year", "Month").agg (avg (col ("AdjClose") ).as ("AverageAdjustedPr") ).withColumn ("AvgAdgPr", round (col ("AverageAdjustedPr"), 1) ).orderBy (col ("Year").desc, col ("Month").desc).show

    //joins
    val df1 = spark.sql ("select * from gowthambha87edu.sparkhive")
    df1.show


    val inp = Seq (Age (24, 2400), Age (25, 2500))
    val df2 = inp.toDF()
    val output = df1.join (df2, Seq ("age") )
    //val out = df1.join (df2, df1.col ("age") === df2.col("age") )
    output.show()

    //using spark sql
    val people = spark.read.json ("/user/gowthambha87edu/sparkDF/people.json")
    people.createOrReplaceTempView ("people table")
    val peopleGt30 = spark.sql ("select * from people table where age > 30")
    //peopleGt30.show
    people.filter (col ("age").gt (30) ).show

  }
}
