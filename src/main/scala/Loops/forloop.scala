package Loops

object forloop {
  def main(args: Array[String]): Unit = {

  //Foreach function used to iterate over string and lists
  val args = "Hello"
    //args.foreach(arg => println(arg))
  args.foreach(println)
  println("---")

  val x = List(1, 2, 3)
  x.foreach {println}
  println("---")

  //For loop
  for (i <- 1 to 5) println(i)
  println("------")

  //for loop to traverse an array
  val in = "Hello World"
  var sum = 0
  for (i <- 0 until in.length) sum = sum + i
  println(sum)

    println("---")

  for (i <- 1 to 5 by 2) println(i)
  println("------")

  // we can have multiple generators in for loop
  for (i <- 1 to 3; j <- 1 to 3) println(10 * i + j)
  println("------")

  //we can put conditions in multiple generators of a for loop
  for (i <- 1 to 3; j <- 1 to 3 if i == j) println(10 * i + j)
  println("------")

  // we can introduce variables in loop
  for (i <- 1 to 3; x = 4 - i; j <- x to 3) println(10 * i + j)
  println("---")

    for (i <- 1 until 5) println(i)
    println("------")

  //yield returns collection of values
  val k = for (i <- 1 to 20) yield i * 2.5
  println(k)
  println("------")
  }
}