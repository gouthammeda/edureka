package Assignments.FunctionalProgramandOOPS
import scala.io.Source
import scala.collection.mutable.ArrayBuffer

object filelinesreverse  {
  def main (args: Array[String])= {
        // Local variable declaration:
//          var a = "Hello World"//
//          println(a.mkString(" "))
//          for ( m1 <-1 to a.size ) {
//                print(a(a.size -m1))
//            }
          val filename1=args(0)
          for (line <- Source.fromFile(filename1).getLines) {
            //println(line)
            val splittedLines = line.split("/n")
            val ab = ArrayBuffer[String]()
            for (ele <- splittedLines) ab += ele
            ab.foreach(println)

            var arraybuffer_length = ab.length
            println("arraybuffer length is", arraybuffer_length)
            //            while (arraybuffer_length!=0) {
            //              println("inside while")
            //              println(ab(arraybuffer_length))
            //              arraybuffer_length = arraybuffer_length - 1
            //            }
          }

      }
   }





