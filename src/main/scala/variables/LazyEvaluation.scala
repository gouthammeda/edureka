package variables

/* Created by gouthamkumarreddymeda on 4/18/23 */
object LazyEvaluation {
  def main(args:Array[String]) {

    //lazy evaluation
    val file = scala.io.Source.fromFile(args(0))
    println(file)

    println("-----")
    //val file = scala.io.Source.fromFile(args(0))
    //-->java.io.FileNotFoundException: /home/gowthambha81edu/sample.txt (No such file or directory)

    //when declared as lazy then it will be called only when it needs to be accessible
    lazy val file1 = scala.io.Source.fromFile(args(0))
    println(file1)


    //m takes the last statement in the expression.
    {
      val m = {
        println("foo");
        1
      }
      println("bar")
      println(m)
    }
    println("-----")


    //if the value is declared as lazy then first bar prints out then foo followed with m.
    //val can only be declared as lazy, but var can't
    {
      lazy val m = {
        println("foo");
        1
      }
      println("bar")
      println(m)
    }

  }
}
