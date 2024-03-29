package spark.Dataframe

import utilities.sparkconfig.spark
/* Created by gouthamkumarreddymeda on 4/17/23 */
object sparksql {
  def main(args: Array[String]) {
    //using spark sql
    val people = spark.read.json(args(0))
    people.createOrReplaceTempView("people")
    val peopleGt30 = spark.sql("select * from people where age > 30")
    peopleGt30.show
  }
}
