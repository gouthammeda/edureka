package datastructures

//arrays --> collection of elements of same data type, they are mutable
/* Created by gouthamkumarreddymeda on 4/15/23 */
object Arrays {
  def main(args: Array[String]): Unit = {

    val a = Array(1, 2, 3)
    a(0)
    //a(4)
    var b = new Array[Int](3)
    b(1)
    b(1) = 2
    b
    val n = new Array[Int](10)
    val s = new Array[String](10)
    val st = Array("Hello", "World")
    val ar1 = Array(1, 2, 3, 4, 5, 6, 7, 8)
    val ar2 = new Array[Int](4)
    ar1(3) = 10

    //ar1(3)= "Deepak" //--> not allowed
    //ar2(5) = 7 // --> can't be done as array length is fixed
    ar1.foreach(println)
    println("------")

    val ar3 = Array(1, 2, 3, 4, 5)
    ar3(2) = 12
    ar3.foreach(println)
    println("------")

  }
}