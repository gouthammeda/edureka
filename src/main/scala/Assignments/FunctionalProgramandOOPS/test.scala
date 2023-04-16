package Assignments.FunctionalProgramandOOPS

import scala.io.Source

//TODO come back to this file for below two solutions
object Main1  {
  def main (args: Array[String])= {
        // Local variable declaration:
          var a = "Hello World"//
          println(a.mkString(" "))
          for ( m1 <-1 to a.size ) {
                print(a(a.size -m1))
            }
      }
   }


object Main2  {
  def main (args: Array[String])= {
    val filename = "/Users/gouthamkumarreddymeda/Documents/prwatech/homework/BooksSample.csv"
    for (line <-Source.fromFile(filename).getLines) {
      var a = line.split(",")
      for ( m1 <-0 to a.size-1 ) {
        if (a(m1).length > 10)
          println(a(m1))}
    }
  }
}


