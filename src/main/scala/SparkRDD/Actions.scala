package SparkRDD

import org.apache.spark.{SparkConf, SparkContext}

/* Created by gouthamkumarreddymeda on 4/16/23 */
object Actions {
  def main(args:Array[String]) {

    val conf = new SparkConf()
      .setMaster("local[1]")
      .setAppName("running actions")
    val sc = new SparkContext(conf)

    //Actions-> data is executed only after the action is hit.
    val c = sc.parallelize(List(" Gnu ", " Cat ", " Rat ", " Dog "), 2)
    c.first

    val a = sc.parallelize(1 to 100, 3)
    a.reduce(_ + _)

    val b = sc.parallelize(List(" dog ", " cat ", " ape ", " salmon ", " gnu "), 2)
    b.takeOrdered(2)

    val f = sc.parallelize(List((3, " Gnu "), (3, " Yak "), (5, " Mouse "), (3, " Dog ")), 2)
    //c.countByKey


    val z = sc.parallelize(List(" a ", " b ", " c ", " d ", " e ", " f "), 2)
    z.aggregate("")(_ + _, _ + _) //come back later
  }
}
