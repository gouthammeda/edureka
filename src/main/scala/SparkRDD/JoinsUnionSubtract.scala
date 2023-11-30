package SparkRDD

import org.apache.spark.{SparkConf, SparkContext}
/* Created by gouthamkumarreddymeda on 4/16/23 */
object JoinsUnionSubtract {
  def main(args:Array[String]) {

    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("running joinsUnionSubtract")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    //RDD Joins:
    val ardd = sc.parallelize(Array("jan", "feb", "march", "april", "may")).map(x => (x.length, x))
    val brdd = sc.parallelize(Array((3, "three letter word"), (4, "four letter word")))

    // (3,jan)    (3,"three letter word")
    // (3,feb)    (4,"four letter word")
    // (5,march)
    // (5,april)
    // (3,may)

    val c = ardd.join(brdd)
    c.collect().foreach(println)
    //all matching elements are joined
    // (3,(jan,three letter word))
    // (3,(feb,three letter word))
    // (3,(may,three letter word))

    println("-----")

    //get all the records in left dataset if there are matches get the value from other dataset or else give null or None
    val d = ardd.leftOuterJoin(brdd)
    // (3,(jan,Some(three letter word)))         (3,jan,three letter word)
    // (3,(feb,Some(three letter word)))
    // (3,(may,Some(three letter word)))
    // (5,(march,None)),
    // (5,(april,None))                          (5,april,ValueNotFound)

    d.collect().foreach(println)
    println("-----")
    //Some and None are options meaning values may be present or not they are provided to handle null values in scala.
    val e = d.map(x => (x._1, x._2._1, x._2._2.getOrElse("ValueNotFound")))
    e.collect().foreach(println)
    println("-----")

    //join
    val s = sc.parallelize(List("dog", "salmon", "salmon", "rat", "elephant"), 3)
    val sLength = s.keyBy(_.length)
    //sLength.collect().foreach(println)

    val v = sc.parallelize(List("dog", "cat", "gnu", "salmon", "rabbit", "turkey", "wolf", "bear"), 3)
    val vLength = v.keyBy(_.length)
    //vLength.collect().foreach(println)
    sLength.join(vLength).collect().foreach(println)
    println("-----")

    //union
    val a = sc.parallelize(1 to 3, 1)
    val b = sc.parallelize(5 to 7, 1)
    (a ++ b).collect.foreach(println)
    println("-----")

    //subtract
    val trdd = sc.parallelize(1 to 9, 3)
    val srdd = sc.parallelize(1 to 3, 3)
    val crdd = trdd.subtract(srdd)
    crdd.collect().foreach(println)
    println("-----")

    //General RDD functions.
    //val b = sc.parallelize(List(1, 1, 1, 1, 3, 3, 3, 4, 4, 8, 8, 9, 9))
    //b.countByValue

    //sample rdd
    val krdd = sc.parallelize(1 to 10000, 3)
    println(krdd.sample(withReplacement = false, fraction = 0.1, seed = 0).count)

    //repetitions --> false
    println(krdd.sample(withReplacement = true, fraction = 0.3, seed = 0).count)
    println(krdd.sample(withReplacement = true, fraction = 0.3, seed = 13).count)

    val xrdd = sc.parallelize(1 to 9, 3)
    val yrdd = sc.parallelize(1 to 3, 3)
    val j = xrdd.subtract(yrdd)
    //println(c.toDebugString)

  }
}
