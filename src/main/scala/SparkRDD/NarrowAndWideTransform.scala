package SparkRDD

import org.apache.spark.{SparkConf, SparkContext}

/* Created by gouthamkumarreddymeda on 4/16/23 */
object NarrowAndWideTransform {
  def main(args:Array[String]){
    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("narrow and wide transform")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    // narrow vs wide transformation.
    val input = sc.parallelize(Array("jan", "feb", "march", "apr", "may", "jan", "feb", "aug", "may"))
    //by default 2 partitions are created.
    val b = input.map(x => (x, x.length))

    //partition 1 "jan","feb","march","apr","may"
    //map         ("jan",3),("feb",3),("march",5),("apr",3),("may",3)
    //reduceByKey
    //
    //partition 2 "jan","feb","aug","may"
    //map         ("jan",3),("feb",3),("aug",3),("may",3)

    val c = b.reduceByKey(_ + _)
    c.collect.foreach(println)

     }
}
