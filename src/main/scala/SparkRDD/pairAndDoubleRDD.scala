package SparkRDD

import org.apache.spark.{SparkConf, SparkContext}

/* Created by gouthamkumarreddymeda on 4/15/23 */
object pairAndDoubleRDD {

  def main(args: Array[String]){
    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("running pair rdds")
    val sc = new SparkContext(conf)
    //Pair RDDS
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

    //persistence level:
    //mem_only: when we have 12 gb of data but 10 gb of ram in mem only all 10 gb is calculated and stored in memory and remaining 2gb is calculated when we hit collect on it
    //mem_disk: when we have 12 gb of data all 12 gb is taken and calculated and 10 gb is stored in mem and remaining 2 gb in disk.

    //serialization: converting textual data to byte stream(o's and 1's)
    //deserialization: converting byte stream to textual data

    //saving in serialized format is used if there is lot of shuffling needs to happen on data we prefer to store it as memory_only_ser as opposed to adding an extra step of serialization in mem_only
    //but if shuffling is not required then we can store it as mem_only as deserialization is not required and cpu is not highly used.

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
    val z = (y ++ y)
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

    file.flatMap(utilFuncs.mySplit(_)).map(x => (x, 1)).reduceByKey((x, y) => (x + y)).collect()

    //RDD Partition and Achieving parallelism
    //shared variables--with broadcast variables are shipped to all executors and cached for future reference.
    val broadcastVar = sc.broadcast(Array(1, 2, 3))
    broadcastVar.value

    //Accumulators: used for aggregating information across executors like number of records or corrupted or calls made to a library api
    val accum = sc.longAccumulator("My Accumulator")
    sc.parallelize(Array(1, 2, 3, 4)).foreach(x => accum.add(x))
    accum.value
    //Quiz:
    //cluster manager provides resources to execute a task

  }

}
