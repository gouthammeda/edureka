package datastructures

//ArrayBuffer - Variable Length Array

/* Created by gouthamkumarreddymeda on 4/18/23 */

import scala.collection.mutable.ArrayBuffer
object AryBuffer {
  def main(args: Array[String]): Unit = {
    val ab = ArrayBuffer[Int]()
    ab += 1
    ab += (2, 3, 4)
    ab ++= Array(6, 7, 8)
    ab.foreach(println)
  }
}