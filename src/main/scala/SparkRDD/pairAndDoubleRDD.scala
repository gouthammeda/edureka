package SparkRDD

import org.apache.spark.{SparkConf, SparkContext}

/* Created by gouthamkumarreddymeda on 4/15/23 */
object pairAndDoubleRDD {
  def main(args: Array[String]){
    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("running pair rdds")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    //General RDD functions.
    val b = sc.parallelize(List(1,1,1,1,3,3,3,4,4,8,8,9,9))
    //b.countByValue

    //sample
    val krdd = sc.parallelize(1 to 10, 3)
    println(krdd.sample(withReplacement = false, fraction = 0.1, seed = 0).count)

    //repetitions --> false
    println(krdd.sample(withReplacement = true, fraction = 0.3, seed = 0).count)
    println(krdd.sample(withReplacement = true, fraction = 0.3, seed = 13).count)

    //Pair RDD'S
    //FoldByKey-->merges values based on function provided.
    val ardd = sc.parallelize(List(" dog ", " cat ", " owl ", " gnu ", " ant "), 2)
    val brdd = ardd.map(x => (x.length, x))
    brdd.foldByKey(" ")(_ + _).collect.foreach(println)

    //lookup--searches for key in the map RDD if exists then shows values.
    val lrdd = sc.parallelize(List(" dog ", " tiger ", " lion ", " duck ", " elephant ", " pigeon"), 3)
    val s = lrdd.map(x => (x.length, x))
    s.lookup(4).foreach(println)

    //collectAsMap --takes an rdd and returns a map
    val a = sc.parallelize(List(1, 2, 1, 3), 1)
    val t = a.zip(a)
    t.collectAsMap.foreach(println)

    //Double RDD functions
    val x = sc.parallelize(List(1.0, 2.0, 3.0, 5.0, 20.0, 19.02, 19.29, 11.09, 21.0))
    println(x.mean)
    println(x.sum)
    println(x.variance)
    println(x.stats)

    //come back later
    //val file = sc.textFile(args(0))
    //val counts = file.flatMap(_.split(" ")).map(x => (x, 1)).reduceByKey(_ + _)
    //if we want to use function in multiple places then it is better to declare it first and then use wherever needed.
    //Passing Anonymous Functions
    //flatMap(_.split(" ")).map(x => (x, 1)).reduceByKey(_ + _)

    object utilFuncs {
      def mySplit(s: String): Array[String] = {
        s.split(" ")
      }
    }
   // file.flatMap(utilFuncs.mySplit(_)).map(x => (x, 1)).reduceByKey((x, y) => x + y).collect()
  }

}
