package SparkRDD

import org.apache.spark.{SparkConf, SparkContext}

/* Created by gouthamkumarreddymeda on 4/15/23 */
object pairAndDoubleRDD {
  def main(args: Array[String]){
    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("running pair rdds")
    val sc = new SparkContext(conf)

    //Pair RDD'S
    //FoldByKey--merges values based on function provided.
    val ardd = sc.parallelize(List(" dog ", " cat ", " owl ", " gnu ", " ant "), 2)
    val brdd = ardd.map(x => (x.length, x))
    brdd.foldByKey(" ")(_ + _).collect
    Array((5, " dog  cat  owl  gnu  ant "))

    //lookup--searches for key in the map RDD if exists then shows values.
    val lrdd = sc.parallelize(List(" dog ", " tiger ", " lion ", " duck ", " elephant ", " pigeon"), 3)
    val s = lrdd.map(x => (x.length, x))
    s.lookup(4)

    //collectAsMap --takes an rdd and returns a map
    val a = sc.parallelize(List(1, 2, 1, 3), 1)
    val b = a.zip(a)
    b.collectAsMap
    Array((1, 1), (2, 2), (1, 1), (3, 3))

    //Double RDD functions
    val x = sc.parallelize(List(1.0, 2.0, 3.0, 5.0, 20.0, 19.02, 19.29, 11.09, 21.0))
    x.mean
    x.sum
    x.variance
    x.stats

    //come back later
    val file = sc.textFile("/user/gowthambha87edu/sample.txt")
    val counts = file.flatMap(_.split(" ")).map(x => (x, 1)).reduceByKey(_ + _)
    //if we want to use function in multiple places then it is better to declare it first and then use wherever needed.
    //Passing Anonymous Functions
    //flatMap(_.split(" ")).map(x => (x, 1)).reduceByKey(_ + _)

    object utilFuncs {
      def mySplit(s: String): Array[String] = {
        s.split(" ")
      }
    }
    file.flatMap(utilFuncs.mySplit(_)).map(x => (x, 1)).reduceByKey((x, y) => x + y).collect()
  }

}
