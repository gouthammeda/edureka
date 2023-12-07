package Assignments.FuncsandOOPS

import scala.io.Source

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
          var length = input.length - 1
          while(length >= 0){
            println(input(length))
            length = length - 1
          }
      }
   }





