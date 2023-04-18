package SparkRDD

import org.apache.spark.{SparkConf, SparkContext}

/* Created by gouthamkumarreddymeda on 4/16/23 */
object Actions {
  def main(args:Array[String]) {

    val conf = new SparkConf()
      .setMaster("local[1]")
      .setAppName("running actions")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    //Actions-> data is executed only after the action is hit.
    val c = sc.parallelize(List(" Gnu ", " Cat ", " Rat ", " Dog "), 2)
    c.first

    val a = sc.parallelize(1 to 100, 3)
    a.reduce(_ + _)

    val b = sc.parallelize(List(" dog ", " cat ", " ape ", " salmon ", " gnu "), 2)
    b.takeOrdered(2)

    val f = sc.parallelize(List((3, " Gnu "), (3, " Yak "), (5, " Mouse "), (3, " Dog ")), 2)
    f.countByKey

    val z = sc.parallelize(List(" a ", " b ", " c ", " d ", " e ", " f "), 2)
    z.aggregate("")(_ + _, _ + _)

    //loading and saving data to files
    val rdd1 = sc.parallelize(Array("jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"), 3)
    rdd1.collect()
    rdd1.first
    rdd1.take(10)
    rdd1.saveAsTextFile(args(0))

    //    spark.SparkFiles
    //    sc.addFile("abc.dat")
    //    val inFile = sc.textFile(SparkFiles.get("abc.dat"))

    //rddOfStrings.saveAsTextFile("out.txt")
    //keyValueRdd.saveAsSequenceFile("sequenceOut")

    //General RDD functions.
    //sample
    val krdd = sc.parallelize(1 to 10, 3)
    krdd.sample(withReplacement = false, fraction = 0.1, seed = 0).count()

    //repetitions--> false
    krdd.sample(withReplacement = true, fraction = 0.3, seed = 0).count()
    krdd.sample(withReplacement = true, fraction = 0.3, seed = 13).count()

  }
}
