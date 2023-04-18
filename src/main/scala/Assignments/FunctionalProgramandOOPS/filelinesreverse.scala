package Assignments.FunctionalProgramandOOPS
import scala.io.Source
import scala.collection.mutable.ArrayBuffer

object filelinesreverse {
  def main (args: Array[String])= {
 //Local variable declaration:
//          var a = "Hello World"
//          println(a.mkString(" "))
//          for ( m1 <-1 to a.size ) {
//                print(a(a.size - m1))
//            }
          val filename1=args(0)
          val input = Source.fromFile(filename1).getLines.toArray
          //input.foreach(println)
          var length = input.length - 1
          //println(length)
          while(length >= 0){
            println(input(length))
            length = length - 1
          }
      }
   }





