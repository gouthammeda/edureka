package Loops

/* Created by gouthamkumarreddymeda on 4/18/23 */
object whileLoop {

  def main(args: Array[String]): Unit = {
    //while loop
    var a = 10
    while (a < 20) {
      println("Value of a:" + a)
      a = a + 1
    }
    println("------")

    //do while loop-->not supported in scala 3.0
    var t = 10
    do {
      println("Value of t:" + t)
      t = t + 1
    } while (t < 20)
    println("------")

    println("Using do while loop in scala")

    var numberOfDonutsBaked = 0
    do {
      numberOfDonutsBaked += 1
      println(s"Number of donuts baked = $numberOfDonutsBaked")
    } while (numberOfDonutsBaked < 10)

  }
}