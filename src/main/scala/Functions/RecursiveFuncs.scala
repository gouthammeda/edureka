package Functions

/* Created by gouthamkumarreddymeda on 4/16/23 */
object RecursiveFuncs {

  def main(args: Array[String]): Unit = {
    //recursive functions
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

    //filtering numbers that are less than the given number within a list using recursion and nested functions
    def fltr(xs1: List[Int], threshold_1: Int) = {
      def process1(ys1: List[Int]): List[Int] =
        if (ys1.isEmpty) ys1
        else if (ys1.head < threshold_1) ys1.head :: process1(ys1.tail)
        else process1(ys1.tail)

      process1(xs1)
    }

    println(fltr(List(1, 9, 2, 8, 3, 7, 4), 5))

    /*1st Itr:
1,9,2,8,3,7,4
1<5:True
1 :: process1(List(9,2,8,3,7,4)) //=(1,9,2,8,3,7,4)

2nd Itr:
9,2,8,3,7,4
9<5:False
process(List(2,8,3,7,4))

3rd Itr:
2,8,3,7,4
2<5:True
1 :: 2 :: process(8,3,7,4)

4th Itr:
8,3,7,4
8<5:False
process1(3,7,4)

5th Itr:
(3,7,4)
3<5: True
1::2::3::process1(List(7,4))

6th Itr:
7<5 False
process(List[4])

7th Itr:
4<5 True 1::2::3::4::List()

output = List(1,2,3,4)
*/
    println("---")

    // we are calling a function inside a function statement, inside function is called as local function
    //factorial using tail recursion
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

  }
}