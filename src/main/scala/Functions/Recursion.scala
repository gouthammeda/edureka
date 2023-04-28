package Functions
//recursive functions
/* Created by gouthamkumarreddymeda on 4/16/23 */
object Recursion {
  def main(args: Array[String]): Unit = {
    //factorial
    def factorial(n: Int): Int = {
      if (n <= 1) 1
      else n * factorial(n - 1)
    }

    println(factorial(5))
    println("------")
    /*
      factorial(5)
      5 * factorial(4),5 is out
      5 * 4 * factorial(3),4 is out
      5 * 4 * 3 * factorial(2),3 is out
      5 * 4 * 3 * 2 * factorial(1),2 is out
      5 * 4 * 3 * 2 * 1,1 is out
      results are multiplied to get 120
      */

    def functionExample(a: Int, b: Int): Int = {
      if (b == 0) 0 else a + functionExample(a, b - 1)
    }
    println(functionExample(15, 2))
    println("------")

    // 1st Itr:
    // a = 15, b= 2
    // 15+functionExample(15,1)
    // 2nd Itr:
    // a = 15 b = 1
    // 15 + 15 + functionExample(15,0)
    // 3rd Itr:
    // 15 + 15 + 0 = 30

    //tail_recursion
    def tail_rec_factorial(i: Int): Int = {
      def fact(i: Int, acc: Int): Int = {
        if (i <= 1) acc else fact(i - 1, i * acc)
      }

      fact(i, 1)
    }

    println(tail_rec_factorial(0))
    println(tail_rec_factorial(1))
    println(tail_rec_factorial(2))
    println(tail_rec_factorial(3))
    println("---")

    // fact(3,1)
    // fact(2,3*1)
    // fact(1,2*3)
    // fact(1,6)
    // 6
    println("---")
  }
}