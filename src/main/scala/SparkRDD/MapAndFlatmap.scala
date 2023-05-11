package SparkRDD

import org.apache.spark.{SparkConf, SparkContext}

/* Created by gouthamkumarreddymeda on 4/15/23 */
object MapAndFlatmap {
  def main(args:Array[String]){

    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("running transforms")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

  //Map:
  //1 input gives 1 output
  val input = sc.parallelize(List("dog", "salmon", "salmon", "rat", "elephant"), 3)
  val b = input.map(_.length)
  val k = input.zip(b)
    k.collect().foreach(println)
  println("-----")
  //flatmap
  val inp = sc.parallelize(1 to 10, 5)
    inp.flatMap(1 to _).collect().foreach(println) // come back later
    println("-----")
  //Filter:
  val f = sc.parallelize(1 to 10, 3)
  val c = f.filter(x => x % 2 == 0)
  //val c = a.filter(_%2==0)
  c.collect().foreach(println)

    println("-----")
  //GroupbyKey:
  val datainput = sc.parallelize(Array(('k', 5), ('s', 3), ('s', 4), ('p', 7), ('p', 5), ('t', 8), ('k', 6)), 3)
  val datagrouped = datainput.groupByKey()
  datagrouped.collect.foreach(println)
    println("-----")

    //Intersection:
  val firstrdd = sc.parallelize(Array((1, "jan", 2016), (3, "nov", 2014), (16, "feb", 2014)))
  val secondrdd = sc.parallelize(Array((1, "jan", 2016), (5, "dec", 2014)))
  val common = firstrdd.intersection(secondrdd)
  common.collect.foreach(println)
    println("-----")

    //word-count using reduce by key
  //ReduceByKey-> It is two step process first it groups the values and then arithmetic operation is performed on those grouped values.
  val words = Array("one", "two", "two", "four", "six", "six", "eight", "nine", "ten")
  val data = sc.parallelize(words).map(x => (x, 1)).reduceByKey((x, y) => x + y)
  data.collect.foreach(println)
    println("-----")

    //distinct
  val rdd1 = sc.parallelize(Array((1, "jan", 2016), (3, "nov", 2014), (16, "feb", 2014), (1, "jan", 2016)))
  val rddDistinct = rdd1.distinct
  rddDistinct.collect.foreach(println)
    println("-----")

  //map vs flatmap
  //map is 1 to 1 mapping, i.e., for a given array single line of an string inside it is giving 1 output, so we will have just 3 outputs
  //in transformed array
  val arr = Array("This is line 1", "This is line 2", "This is line 3")
  val input_rdd = sc.parallelize(arr)
  val output = input_rdd.map(x => x.split(" "))
  output.collect().foreach(println)
  // This is line 1 Array(This, is, line, 1),
  // This is line 2 Array(This, is, line, 2),
  // This is line 3 Array(This, is, line, 3)

  //Array(This is line 1, This is line 2, This is line3)

    println("-----")
    //come back to it and later convert it to Array(This is line 1, This is line 2, This is line3)
  val a = Array("This is line 1", "This is line 2", "This is line3")
  val ardd = sc.parallelize(a)
  val flatmaprdd = ardd.flatMap(x => x.split(" "))
  flatmaprdd.collect().foreach(println)
  // 1 line of string within an array is giving 4 outputs so we will have total of 12 outputs in the final array.
  // This is line 1   This,
  //                  is,
  //                  line,
  //                  1,
  // This is line 2   This,
  //                  is,
  //                  line,
  //                  2,
  // This is line3    This,
  //                  is,
  //                  line
  //                  3
  }
}
