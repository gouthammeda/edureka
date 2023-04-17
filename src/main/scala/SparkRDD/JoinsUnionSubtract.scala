package SparkRDD

import org.apache.spark.{SparkConf, SparkContext}
/* Created by gouthamkumarreddymeda on 4/16/23 */
object JoinsUnionSubtract {
  def main(args:Array[String]) {

    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("running transformations")
    val sc = new SparkContext(conf)
    //RDD Joins:
    val ardd = sc.parallelize(Array("jan", "feb", "march", "april", "may")).map(x => (x.length, x))
    val brdd = sc.parallelize(Array((3, "three letter word"), (4, "four letter word")))

    // (3,jan)    (3,"three letter word")
    // (3,feb)    (4,"four letter word")
    // (5,march)
    // (5,april)
    // (3,may)

    val c = ardd.join(brdd) //all matching elements are joined
    // (3,(jan,three letter word))
    // (3,(feb,three letter word))
    // (3,(may,three letter word))

    val d = ardd.leftOuterJoin(brdd)
    // (3,(jan,Some(three letter word)))         (3,jan,three letter word)
    // (3,(feb,Some(three letter word)))
    // (3,(may,Some(three letter word)))
    // (5,(march,None)),
    // (5,(april,None))                          (5,april,ValueNotFound)

    //Some and None are options meaning values may be present or not they are provided to handle null values in scala.
    val e = d.map(x => (x._1, x._2._1, x._2._2.getOrElse("ValueNotFound")))
    e.collect()

    //join
    val s = sc.parallelize(List("dog", "salmon", "salmon", "rat", "elephant"), 3)
    val swithLength = s.keyBy(_.length)
    val v = sc.parallelize(List("dog", "cat", "gnu", "salmon", "rabbit", "turkey", "wolf", "bear"), 3)
    val dwithLength = v.keyBy(_.length)
    swithLength.join(dwithLength).collect

    //union
    val a = sc.parallelize(1 to 3, 1)
    val b = sc.parallelize(5 to 7, 1)
    (a ++ b).collect

    //subtract
    val trdd = sc.parallelize(1 to 9, 3)
    val srdd = sc.parallelize(1 to 3, 3)
    val crdd = trdd.subtract(srdd)
    crdd.collect()

    val m = sc.parallelize(List(1, 2, 3, 4, 5, 6, 7, 8, 2, 4, 2, 1, 1, 1, 1, 1))
    //b.countByValue

    val krdd = sc.parallelize(1 to 10000, 3)
    krdd.sample(false, 0.1, 0).count

    //repetitions--> false
    krdd.sample(true, 0.3, 0).count
    krdd.sample(true, 0.3, 13).count //come back later

  }
}
