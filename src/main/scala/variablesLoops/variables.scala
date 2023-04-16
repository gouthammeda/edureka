
object variables {
  def main(args: Array[String]): Unit = {
    //scala  /home/prakash/Desktop/babyname.scala
    //:load [scala file path]
    //below expression will be evaluated to 12 by the repl
    println(10 + 2)
    println("Edureka")
    //data types in scala
    println(true)
    println('C')
    println(12.5)
    //variables are memory locations for storing values.
    //initialize value of a with 10
    val x = 10
    //x = 13
    val e = x.toString

    //even tough we didn't declare the type it is automatically inferred and remains same for entire scope,
    //making scala statically typed language.
    //val are immutable but var is mutable.
    var msg = "Hello World"
    msg = "Hello"

    var y = 13
    y = 12
    //x = "Edureka"

    //in scala block is list of expressions and result is also an expression.
    //value of block is the value of last expression of it.
    val z = {
      val a = 10
      val b = 100
      b - a
    }
    val d = {
      val a = 10
      val b = 100
      b - a
      a - b
    }
    val opt1 = Some("Edureka")
    val opt2 = None

    //lazy evaluation
    val file = scala.io.Source.fromFile(args(0))
    //val file1 = scala.io.Source.fromFile(args(0))
    //-->java.io.FileNotFoundException: /home/gowthambha81edu/sample.txt (No such file or directory)
    lazy val file2 = scala.io.Source.fromFile(args(0))

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

    //if it is declared as lazy then first bar prints out then foo followed with m.
    //val can only be declared as lazy, but var can't
    {
      lazy val m = {
        println("foo");
        1
      }
      println("bar")
      println(m)
    }
    println("-----")

    //if statement:
    var p = 15;
    if (p < 20) {
      println("This is if statement")
    }
    println("-----")
    //if-else statement:
    val a = 10
    if (a > 10) 1 else 0
    if (a > 10) "greater than 10" else 0
    println("-----")
    //assigning output of if-else to a value
    var h = 5
    val s = if (h > 0 && h < 6) 1 else 0
    val l = if (h > 0 && h < 6) "positive" else 0
  }
}