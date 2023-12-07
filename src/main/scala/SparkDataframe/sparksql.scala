package SparkDataframe

import utilities.sparkconfig.spark


/* Created by gouthamkumarreddymeda on 4/17/23 */
object sparksql {
  def main(args: Array[String]) {
    //using spark sql
    val people = spark.read.json(args(0))
    people.createOrReplaceTempView("people_table")
    val peopleGt30 = spark.sql("select * from people_table where age > 30")
    peopleGt30.show
//    people.filter(col("age").gt(30)).show

  }
}
