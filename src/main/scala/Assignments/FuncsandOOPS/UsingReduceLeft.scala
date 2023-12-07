package Assignments.FuncsandOOPS

object UsingReduceLeft {
  def findMax(x: Int, y: Int): Int = {
    val winner = x max y
    println("compared %d to %d,%d was larger".format(x, y, winner))
    winner
  }
  def multiply(a: Int, b: Int) = a * b

  def main(args: Array[String]) = {
    val a = Array(3, 5, 2, 10, 15, 7, 8, 13)
    println(a.reduceLeft(findMax))
    println ((5 to 1 by -1).reduceLeft(multiply))

  }
}


