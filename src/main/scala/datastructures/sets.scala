package datastructures

/* Created by gouthamkumarreddymeda on 4/15/23 */
object sets {
  def main(args: Array[String]) {
    //set --> removes the duplicates and order is not guaranted, it contains elements of same type.
    //sets are both mutable and immutable.

    import scala.collection.mutable.Set

    val set1 = Set(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9)
    val set2 = Set(8, 9, 10)
    val set3 = set1.intersect(set2)
    val set4 = set1.union(set2)

    //set of integer type
    var o: Set[Int] = Set(1, 3, 5, 7)
    val fruits1 = Set("apples", "oranges", "pears")
    val num: Set[Int] = Set()
    println("Head of fruit:" + fruits1.head)
    println("Tail of fruit:" + fruits1.tail)
    println("Check if fruit is empty: " + fruits1.isEmpty)
    println("Check if num is empty:" + num.isEmpty)

    var s1 = Set(7, 9, 8, 9)
    var s2 = Set(10, 11, 12, 13)
    s1 ++ s2
    //s1.++(s2)
    println("-----")

    var a1 = Set(11, 44, 33, 22)
    var b1 = Set(77, 99, 22, 88)
    //a1.&(b1)
    //a1.intersect(b1)
  }
}