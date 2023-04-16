package SparkRDD

import org.apache.spark.{SparkConf, SparkContext}
/* Created by gouthamkumarreddymeda on 4/16/23 */
object Transformation2 {
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

    //Join:
//    val ardd = sc.parallelize(List("dog", "salmon", "salmon", "rat", "elephant"), 3)
//    val b = ardd.keyBy(_.length)
//    val c = sc.parallelize(List("dog", "cat", "gnu", "salmon", "rabbit", "turkey", "wolf", "bear"), 3)
//    val d = c.keyBy(_.length)
//    b.join(d).collect

    //union
    val a = sc.parallelize(1 to 3, 1)
    val b = sc.parallelize(5 to 7, 1)
    (a ++ b).collect

    // coalesce and repartition
    // in coalesce there is minimum movement of data takes place across a partition but would become bottleneck for further processing for partition that has more records when compared with
    // less number of records.
    // second and third partition are added of total 3 partitions and first remains untouched in coleasce
    // repartition is where lot of shuffling takes place but data is equally distributed among partition further processing on those records will be faster
    // repartition is expensive processes as compared with coalesce as there is lot of shuffling that is happening.
    // in repartition the order is not maintained in partitions.
    // 1 partition may be present on totally different server as well so performance wise repartition is costly as data might be transferred through a network.
    // coalesce only used for decreasing the partitions with repartition we can increase the partitions.
    //if there are four partitions and coalesce of 2 is given then records of 2 partitions will be merged using coalesce.

    val rdd1 = sc.parallelize(Array("jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"), 3)
    val rdd2 = rdd1.coalesce(2)
    val rdd3 = rdd1.repartition(2)


    rdd1.getNumPartitions
    rdd2.getNumPartitions
    rdd3.getNumPartitions

    //glom() method is used to the data for each partition.
    rdd1.glom().collect()(0)
    rdd1.glom().collect()(1)
    rdd1.glom().collect()(2)

    rdd2.glom().collect()(0)
    rdd2.glom().collect()(1)

    rdd2.glom().collect()(0)
    rdd2.glom().collect()(1)

    //messages.map { case (key, value) => value.split(',')}

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
