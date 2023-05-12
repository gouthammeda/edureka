package SparkDataset

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._


/* Created by gouthamkumarreddymeda on 4/16/23 */
object Dataset {
  def main(args: Array[String]) {

    val spark = SparkSession
      .builder
      .appName("dataset")
      .master("local")
      .getOrCreate()
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
  }
}
