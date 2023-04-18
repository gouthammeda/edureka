package Assignments.FunctionalProgramandOOPS
import scala.io.Source

/* Created by gouthamkumarreddymeda on 4/17/23 */
object Wordcount {

    def main(args: Array[String]) = {
      val filename = args(0)
      var input = ""
      for (line <- Source.fromFile(filename).getLines) {
        val a = line.split(" ")
        println("The size is",a.size)
        //a.foreach(println)
        for (m1 <- 0 until a.size - 1) {
          if (a(m1).length > 10) {
            input = input + a(m1)
          }
        }
      }
      println(input)
    }
}
