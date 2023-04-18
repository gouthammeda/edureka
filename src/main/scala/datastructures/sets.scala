package datastructures

import scala.collection.mutable.Set
//set --> removes the duplicates and order is not guaranteed, it contains elements of same type.
//sets are both mutable and immutable.


/* Created by gouthamkumarreddymeda on 4/15/23 */
object sets {
  def main(args: Array[String]) {

    //set of integer type
    val o: Set[Int] = Set(1, 3, 5, 7)
    println(o)
    val fruits1 = Set("apples", "oranges", "pears")
    val num: Set[Int] = Set()
    println("Head of fruit:" + fruits1.head)
    println("Tail of fruit:" + fruits1.tail)
    println("Check if fruit is empty: " + fruits1.isEmpty)
    println("Check if num is empty:" + num.isEmpty)
    println("-----")

    val set1 = Set(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9)
    val set2 = Set(8, 9, 10)
    val set3 = set1.intersect(set2)
    println(set3)
    val set4 = set1.union(set2)
    println(set4)
    println("-----")

    //concatenating sets.
    val s1 = Set(7, 9, 8, 9)
    val s2 = Set(10, 11, 12, 13)
    println(s1 ++ s2)
    //s1.++(s2)
    println("-----")

    //intersection
    val a1 = Set(11, 44, 33, 22)
    val b1 = Set(77, 99, 22, 88)
    println(a1.&(b1))

  }
}