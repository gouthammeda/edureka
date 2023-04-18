package variablesIfElse
//scala  /home/prakash/Desktop/sample.scala
//:load [scala file path]

object variables {
  def main(args: Array[String]): Unit = {

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
    println(e)

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
    println(z)

//    val opt1 = Some("Edureka")
//    println(opt1)
//    val opt2 = None
//    println(opt2)

  }
}