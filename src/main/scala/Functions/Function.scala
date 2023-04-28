package Functions

/* Created by gouthamkumarreddymeda on 4/15/23 */
object Function {
  def main(args: Array[String]) = {

    //without = without parameters
    def sayhello() {
      println("Hello")
    }
    sayhello()

    println("---")

    //without=with parameters
    def sum(a: Int, b: Int): Unit = {
      println(a + b)
    }
    sum(1, 2)

    //with = without parameters
    def func(): Int = {
      7
    }

    func()

    //with = with parameters
    def sumwithreturnInt(a: Int, b: Int): Int = {
      a + b
    }
    sumwithreturnInt(1, 2)
    println("---")

    def MaxOutOfTwo(x: Int, y: Int): Int = {
      if (x > y) x else y
    }

    println(MaxOutOfTwo(1, 2))
    println("------")

    //when we pass the arguments that will be considered over defaults.
    def MaxOutOfTwowithDefaults(x: Int = 0, y: Int = 0) = {
      if (x > y) x else y
    }

    println(MaxOutOfTwowithDefaults(1))
    println("------")

    //procedures--> functions without '=' sign
    def rect_area(length: Float, breadth: Float) {
      val area = length * breadth;
      print(area)
    }
    rect_area(1, 2)

  }
}
