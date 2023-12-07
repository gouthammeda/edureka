package SparkRDD
import utilities.sparkconfig.sc

/* Created by gouthamkumarreddymeda on 4/16/23 */
object Actions {
  def main(args:Array[String]) {
    //Actions-> data is executed only after the action is hit.
    val c = sc.parallelize(List(" Gnu ", " Cat ", " Rat ", " Dog "), 2)
    println(c.first)

    val a = sc.parallelize(1 to 100, 3)
    println(a.reduce(_ + _))

    val b = sc.parallelize(List(" dog ", " cat ", " ape ", " salmon ", " gnu "), 2)
    b.takeOrdered(2).foreach(println)

    val f = sc.parallelize(List((3, " Gnu "), (3, " Yak "), (5, " Mouse "), (3, " Dog ")), 2)
    f.countByKey.foreach(println)

    val z = sc.parallelize(List(" a ", " b ", " c ", " d ", " e ", " f "), 2)
    println(z.aggregate("")(_ + _, _ + _))

  }
}
