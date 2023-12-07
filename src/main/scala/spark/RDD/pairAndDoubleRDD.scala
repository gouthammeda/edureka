package spark.RDD

import utilities.sparkconfig.sc
/* Created by gouthamkumarreddymeda on 4/15/23 */
object pairAndDoubleRDD {
  def main(args: Array[String]){
    //Pair RDD'S
    //FoldByKey-->merges values based on function provided.
    val ardd = sc.parallelize(List(" dog ", " cat ", " owl ", " gnu ", " ant "), 2)
    val brdd = ardd.map(x => (x.length, x))
    brdd.foldByKey(" ")(_ + _).collect().foreach(println)

    //lookup--searches for key in the map RDD if exists then shows values.
    val lrdd = sc.parallelize(List(" dog ", " tiger ", " lion ", " duck ", " elephant ", " pigeon"), 3)
    val s = lrdd.map(x => (x.length, x))
    s.lookup(4).foreach(println)

    val c = sc.parallelize(List((3," Gnu "),(3," Yak "),(5,"Mouse"),(3,"Dog")),2)
    //c.countByKey()

    //collectAsMap --takes an rdd and returns a map
    val a = sc.parallelize(List(1, 2, 1, 3), 1)
    val t = a.zip(a)
    t.collectAsMap.foreach(println)

    println("------")

    //Double RDD functions
    val x = sc.parallelize(List(1.0, 2.0, 3.0, 5.0, 20.0, 19.02, 19.29, 11.09, 21.0))
    println(x.mean)
    println(x.sum)
    println(x.variance)
    println(x.stats)

  }

}
