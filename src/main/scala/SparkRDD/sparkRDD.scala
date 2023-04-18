package SparkRDD

import org.apache.spark
import org.apache.spark.{SparkConf, SparkContext, SparkFiles}

/* Created by gouthamkumarreddymeda on 4/15/23 */
object sparkRDD {
  def main(args: Array[String]) {
    //configuring spark properties:

    //spark properties control most application settings and are configured separately for each application
    //properties can be set in spark conf passed to your spark context.
    val conf = new SparkConf()
      .setMaster("local[1]")
      .setAppName("Creating RDD")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    //3 ways to create RDDs
    //1.parallelize Method
    val a = Array("jan", "Feb", "March")
    val ardd = sc.parallelize(a)
    ardd.collect.foreach(println)

    //2. Transformation on existing RDD
    val words = sc.parallelize(Seq("the", "quick"))
    val wordPair = words.map(w => (w.charAt(0), w))
    val wordPair1 = wordPair.collect()
    wordPair1.foreach(println)

    val brdd = ardd.map(x => (x, x.length))
    brdd.collect.foreach(println)

    //3.collect --> converts rdd to scala collection foreach is a for loop working on each item in collection to print it in single line.
    val fileRdd = sc.textFile(args(0))
    fileRdd.collect.foreach(println)

    //rdd workflow:
    //RDD Objects are used to build operator DAG, then there will be DAG scheduler to split graph
    // into stages of task and stages are submitted when ready then and launch
    // task via cluster manager.Execute tasks store and serve blocks.

  }
}