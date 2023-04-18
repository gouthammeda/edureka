package SparkRDD

import org.apache.spark.{SparkConf, SparkContext}

/* Created by gouthamkumarreddymeda on 4/17/23 */
object MemoryPersistence {

  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("running pair rdds")
    val sc = new SparkContext(conf)

    //persistence
    val l = sc.parallelize(Array("jan", "feb", "march", "april", "may")).map(x => (x.length, x))
    l.cache
    l.take(4)
    l.getStorageLevel
    //changing storage level
    l.unpersist()
    l.persist(org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK)
    l.take(4)
    l.getStorageLevel

    l.unpersist()
    l.persist(org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK_SER)
    l.take(4)
    l.getStorageLevel

    val y = sc.parallelize(1 to 10, 10)
    val z = y ++ y
    z.collect
    z.unpersist(true)

    //persistence
    val p = sc.parallelize(1 to 100000, 2)
    p.persist(org.apache.spark.storage.StorageLevel.DISK_ONLY)
    p.getStorageLevel.description

    //cache
    val textFile = sc.textFile("README.md")
    textFile.count()
    textFile.first()
    val linesWithSpark = textFile.filter(line => line.contains("spark"))
    linesWithSpark.cache()

  }
}