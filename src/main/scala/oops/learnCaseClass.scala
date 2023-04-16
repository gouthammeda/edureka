package oops

//case class--> don't need new keyword to instantiate object
//case class-don't need a constructor as well.

object learnCaseClass {
  def main(args:Array[String])= {
    case class Book(isbn: String) {
    }
    val test = Book("978-0486")

    //case class
    case class learnCaseClass(isbn: String) {}
    val frank = new learnCaseClass("987-123")
    val frank1 = new learnCaseClass("987-123")
    println(frank == frank1)
    //when we use normal class both the memory location and values are compared
    //for strings but with case class only values are compared and returns true

    //matching on case classes
    case class Person(name: String, age: Int) {
      val alice = new Person("Alice", 25)
      val bob = new Person("Bob", 32)
      val charlie = new Person("Charlie", 32)
      for (person <- List(alice, bob, charlie))
        person match {
          case Person("Alice", 25) => println("Hi Alice!")
          case Person("Bob", 32) => println("Hi Bob!")
          case Person(name, age) => println("Age:" + age + " year, name:" + name + "?")
        }
    }
      def matchTest(x: Any): Any = x match {
        case 1 => "one"
        case "two" => 2
        case y: Int => "scala.Int"
        case _ => "many"
      }

      println(matchTest("two"))
      println(matchTest(true))
      println(matchTest(11))

  }
}