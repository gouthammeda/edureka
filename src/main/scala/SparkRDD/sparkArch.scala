package SparkRDD

import org.apache.spark
import org.apache.spark.{SparkConf, SparkContext, SparkFiles}

//Spark Architecture:
//spark context object in driver program co-ordinates all distributed and resource allocation like,
//how many executors to be launched with memory and number of cores
//executor is a process that is launched for spark application on worker node.

//cluster manager provide executors with jvm process with logic.
//spark context object sends application to cluster and executes task in each executor.

//spark deployment modes:
//Amazon EC2, stand alone mode, mesos,yarn

//spark deployment modes on YARN:

// in cluster mode spark driver runs in application master on cluster host.
// single process in a YARN container is responsible for both driving the application and requesting resources from YARN.

//In client mode, driver runs on the host where job is submitted.
//application master is merely present to request executor containers from YARN.
//client communicates with containers to schedule work after they start.
// spark shell is known as driver program running in the same machine were job is submitted so it is client mode
// In the cluster mode we just take input from one HDFS location and submit output to another HDFS location
// but in client mode we execute sample programs in shell and see the results.
// when we create an spark context object then instance is automatically created so it becomes executable


/* Created by gouthamkumarreddymeda on 4/15/23 */
object sparkArch {
  def main(args: Array[String]) {

    //building:
//    sbt
//    package
//    spark - submit --
//    class "Hello" -- master yarn / home / gowthambha81edu / HelloWorld / target / scala -2.11 / hello - world_2
//    .11 - 1.0.jar
//    spark - submit --
//    class "Hello" -- master yarn -- executor -memory
//    1 g -- executor -cores
//    1 / home / gowthambha81edu / HelloWorld / target / scala - 2.11 / hello - world_2
//    .11 - 1.0.jar

    //configuring spark properties:
    //spark properties control most application settings and are configured separately for each application
    //properties can be set in spark conf passed to your spark context.
    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("CountingSheep")
    val sc = new SparkContext(conf)
    //dynamically loading spark properties:
    //val sc = new SparkContext(new SparkConf())

//    spark - submit -- name
//    "My app" -- master yarn -- conf spark.eventLog.enabled = false
//    -- conf "spark.executor.extraJavaOptions=-XX:+PrintGCDetails -XX:+PrintGCTimeStamps" App
//    .jar

    //rdd try to solve the problems of distributive iterative computing by enabling fault tolerant, distributed
    // in-memory computations
    //since rdd are created over set of transformations, it logs those transformations, rather than actual data
    // if we lose some partition of RDD, we can replay transformation on that partition in lineage to achieve
    // same computation, rather than doing data replication across multiple nodes.

    //RDD:Resilient Distributed Datasets.
    //rdd is a distributed memory abstraction which lets programmers perform in-memory computations on large cluster in
    //a fault-tolerant manner.

    // there are several operations performed on rdds:
    // 1.functions, transformations, actions
    //In-memory computation, Fault Tolerance, Persistence, lazy evaluation, coarse grained operation, persistance, partitionining
    //and immutability
    // coarse grained operations --> applies on each and every element in dataset through map,flatmap and group by operations.

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

    val fileRdd = sc.textFile("/user/gowthambha81edu/sample.txt")
    fileRdd.collect.foreach(println)

    //rdd workflow:
    //RDD Objects are used to build operator DAG, then there will be DAG scheduler to split graph
    // into stages of task and stages are submitted when ready then and launch
    // task via cluster manager.Execute tasks store and serve blocks.

    //loading and saving files
    spark.SparkFiles;
    sc.addFile("abc.dat")
    val inFile = sc.textFile(SparkFiles.get("abc.dat"))

    //rddOfStrings.saveAsTextFile("out.txt")
    //keyValueRdd.saveAsSequenceFile("sequenceOut")

    val rdd1 = sc.parallelize(Array("jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"), 3)
    rdd1.collect()
    rdd1.first
    rdd1.take(10)
    rdd1.saveAsTextFile("/user/gowthambha87edu/sampleOutput")
  }
}