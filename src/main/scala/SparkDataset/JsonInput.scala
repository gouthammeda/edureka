package SparkDataset

import utilities.sparkconfig.spark
import spark.implicits._
import utilities.caseclassHelper.Employee

/* Created by gouthamkumarreddymeda on 4/16/23 */
object JsonInput {
  def main(args: Array[String]) {
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
