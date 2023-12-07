package Functions

/* Created by gouthamkumarreddymeda on 4/15/23 */
object HigherOrderFunc{
  def main(args:Array[String]) {
    //Take a function as an argument or it can return function as an output.
    def apply(f: Int => String, v: Int) = f(v)

    //def id(x:Int):Int = x
    def square(x: Int): Int = x * x
    def cube(x: Int): Int = x * x * x

    //sum of integers between a and b.
    def sumInts(a: Int, b: Int): Int = if (a > b) 0 else a + sumInts(a + 1, b)
    println(sumInts(2, 3))

    def sumCubes(a: Int, b: Int): Int = if (a > b) 0 else cube(a) + sumCubes(a + 1, b)
    println(sumCubes(2, 3))

    def fact(x: Int): Int = if (x == 0) 1 else x * fact(x - 1)
    println(fact(5))

    def sumFactorials(a: Int, b: Int): Int = if (a > b) 0 else fact(a) + sumFactorials(a + 1, b)
    println(sumFactorials(2, 3))

    //sum of square of a number for a range
    // 1,4
    // 1 + 4 + 9 + 16 = 30
    // 1,5 = 55

    println("-------")

    //Higher order Recursive Function
    def sumOfSquares(x: Int, y: Int): Int = {
      if (x > y) 0
      else x * x + sumOfSquares(x + 1, y)
    }
    // x y condition output
    // 1 4   False   1 + sumOfSquares(2,4)
    // 2 4   False   1 + 4 + sumOfSquares(3,4)
    // 3 4   False   1 + 4 + 9 + sumOfSquares(4,4)
    // 4 4   False   1 + 4 + 9 + 16 + sumOfSquares(5,4)
    // 5 4   True    1 + 4 + 9 + 16 + 0 = 30

    def sumOfCubes(x: Int, y: Int): Int = {
      if (x > y) 0
      else x * x * x + sumOfCubes(x + 1, y)
    }

    def sumHO(x: Int, y: Int, f: Int => Int): Int = {
      if (x > y) 0
      else f(x) + sumHO(x + 1, y, f)
    }

    //calling higher order function without anonymous function by creating the function with name square.
    println(sumHO(1, 4, square))
    println(sumHO(1, 4, cube))

    //we are passing anonymous function as an argument to above higher order function.
    println(sumHO(2, 4, in => in * in))
    println(sumHO(2, 4, in => in * in * in))

    println("-------")

    //useful higher order functions
    (1 to 9).map(0.1 * _).foreach(println)
    (1 to 9).map("*" * _).foreach(println)
    (1 to 9).filter(_ % 2 == 0).foreach(println)
    println((1 to 9).reduceLeft(_ * _))
    "Mary had a little lamb".split(" ").sortWith(_.length < _.length).foreach(println)
  }
}
