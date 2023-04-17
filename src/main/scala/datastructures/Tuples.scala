package datastructures

/* Created by gouthamkumarreddymeda on 4/15/23 */
object Tuples {
  def main(args: Array[String]) {
    //Tuples are immutable and can contain elements of different datatype.
    val u = (1, 4, "Bob", "Jack")
    println(u)
    println(u._2)
    //u _2
    println("-----")
    val ab = (4, 3, 2, 1)
    ab.productIterator.foreach { i => println("Value=" + i) }
    println("-----")
    val f = ("exam", "test")
    println("Swapped Tuple: " + f.swap)
    println("-----")
    val mn = (1, "wonderful", 20.2356)
    println("Concatenated String: " + mn.toString())

  }
}