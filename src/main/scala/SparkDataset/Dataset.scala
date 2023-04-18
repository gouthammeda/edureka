package SparkDataset

import org.apache.spark.sql.types._
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}


/* Created by gouthamkumarreddymeda on 4/16/23 */
object Dataset {
  def main(args: Array[String]) {

    val spark = SparkSession
      .builder
      .appName("dataset")
      .master("local")
      .getOrCreate()

    val conf = new SparkConf()
      .setMaster("local[1]")
      .setAppName("running actions")
    val sc = new SparkContext(conf)
    import spark.implicits._

    //Dataset
    val employeeDS = spark.read.json(args(0)).as[Employee]
    employeeDS.show()
    //Dataframe
    val employeeDF = spark.read.json(args(0))
    employeeDF.show()

//    dataframe we get compile errors but in dataset we get runtime errors-- which is true
//    in dataset we get compile time errors -- check this statement.
    val caseClassDS = Seq(Employee("Andy", 32)).toDS()
    caseClassDS.show

    val primitiveDS = Seq(1, 2, 3).toDS()
    primitiveDS.map(_ + 1).collect

//    creating Dataframe from RDD by specifying schema
//     John,34
//     singh,45
//     joe,23
//     goutham,32

    val employeeRDD = sc.textFile("/user/gowthambha87edu/sparkRDD/employee.txt")
    val schemaString = "name age"
    val fields = schemaString.split(" ").map(fieldName => if (fieldName == "name") StructField(fieldName, StringType, nullable = true) else StructField(fieldName, IntegerType, nullable = true))
    val schema = StructType(fields)

    val rowRDD = employeeRDD.map(_.split(",")).map(attrib => Row(attrib(0), attrib(1).trim.toInt))
    val employeeData = spark.createDataFrame(rowRDD, schema)
    employeeData.show

//    converting rdd's to datasets
//     1.inferring schema of an rdd using reflection to create dataset
//     2.creating datasets by specifying schema within program and apply it on existing rdd

    val empDF = sc.textFile("/user/gowthambha87edu/sparkDF/employee.txt").map(_.split(",")).map(attributes => Employee(attributes(0), attributes(1).trim.toInt)).toDF()
    empDF.createOrReplaceTempView("employee")

    val youngstersDF = spark.sql("select name,age from employee where age between 18 and 30")
    youngstersDF.map(youngster => "Name:" + youngster(0)).show()

    youngstersDF.map(youngster => "Name: " + youngster.getAs[String]("name")).show()
    implicit val mapEncoder = org.apache.spark.sql.Encoders.kryo[Map[String, Any]]
    youngstersDF.map(youngster => youngster.getValuesMap[Any](List("name", "age"))).collect()
    //performance tuning
    //dataFrame.cache()
  }
}
