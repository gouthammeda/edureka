package SparkRDD

import org.apache.spark.{SparkConf, SparkContext}

/* Created by gouthamkumarreddymeda on 4/17/23 */
object MemoryPersistence {

  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("running memoryPersistence")
    val sc = new SparkContext(conf)

    sc.setLogLevel("ERROR")

    //persistence
    val l = sc.parallelize(Array("jan", "feb", "march", "april", "may")).map(x => (x.length, x))
    l.cache
    l.take(4).foreach(println)
    println(l.getStorageLevel)

    println("------")
    val p = sc.parallelize(1 to 100000, 2)
    p.persist(org.apache.spark.storage.StorageLevel.DISK_ONLY)
    println(p.getStorageLevel.description)

    println("------")

    //changing storage level
    l.unpersist()
    l.persist(org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK)
    l.take(4)

    println(l.getStorageLevel)

    println("------")

    l.unpersist()
    l.persist(org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK_SER)
    l.take(4)
    println(l.getStorageLevel)

    println("------")

    val y = sc.parallelize(1 to 10, 10)
    val z = y ++ y
    z.collect
    z.unpersist(true)
    println(z.getStorageLevel)

    //cache
//    val textFile = sc.textFile(args(0))
//    textFile.count()
//    textFile.first()
//    val linesWithSpark = textFile.filter(line => line.contains("spark"))
//    linesWithSpark.cache()

  }
}