package SparkRDD

import org.apache.spark.{SparkConf, SparkContext}

/* Created by gouthamkumarreddymeda on 4/17/23 */
object CoalesceAndRepartition {
    def main(args:Array[String]) {
      val conf = new SparkConf()
        .setMaster("local[1]")
        .setAppName("coalesce and repartition")
      val sc = new SparkContext(conf)
      sc.setLogLevel("ERROR")

      val rdd1 = sc.parallelize(Array("jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"), 3)
      val rdd2 = rdd1.coalesce(2)
      val rdd3 = rdd1.repartition(2)

      println(rdd1.getNumPartitions)
      println(rdd2.getNumPartitions)
      println(rdd3.getNumPartitions)
      println("-----")

      // glom method is used to the data for each partition.
      rdd1.glom().collect()(0).foreach(println)
      rdd1.glom().collect()(1).foreach(println)
      rdd1.glom().collect()(2).foreach(println)

      println("-----")
      rdd2.glom().collect()(0).foreach(println)
      rdd2.glom().collect()(1).foreach(println)

      println("-----")
      rdd3.glom().collect()(0).foreach(println)
      rdd3.glom().collect()(1).foreach(println)

    }
}
