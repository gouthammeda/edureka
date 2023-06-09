package SparkDataset

import org.apache.spark.sql.SparkSession


/* Created by gouthamkumarreddymeda on 4/16/23 */
object DatasetcreationJsonInput {
  def main(args: Array[String]) {

    val spark = SparkSession
      .builder
      .appName("dataset")
      .master("local")
      .getOrCreate()
    import spark.implicits._
    spark.sparkContext.setLogLevel("ERROR")

//    dataframe we get compile errors but in dataset we get runtime errors-- which is true
//    using Seq() collection to create a dataset.
    val caseClassDS = Seq(Employee("Andy", 32)).toDS()
    caseClassDS.show

    //dataset creation
    val primitiveDS = Seq(1, 2, 3).toDS()
    primitiveDS.map(_ + 1).collect.foreach(println)

    //converting dataframe to Dataset by reading a file.
    val employeeDS = spark.read.json(args(0)).as[Employee]
    employeeDS.show()

  }
}
