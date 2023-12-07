package datastructures
import scala.collection.mutable.ListBuffer

//List buffer supports adding elements to it
/* Created by gouthamkumarreddymeda on 4/18/23 */
object LstBuffer {
  def main(args: Array[String]) {
    val k = ListBuffer[Int]()
    k += 1
    k += (1, 2, 3, 4, 5)
    println(k)

    val fruits = new ListBuffer[String]()
    fruits += "Apple"
    fruits += ("Strawberry", "Kiwi", "Pineapple")
    fruits -= ("Apple", "Kiwi")
    val fruitsList = fruits.toList
    println(fruitsList)


  }
}