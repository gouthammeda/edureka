package oops.classes
//case class--> don't need new keyword to instantiate object and don't need a constructor as well.
case class Book(isbn: String){}
case class learnCaseClass(isbn: String){}
case class Person(name: String, age: Int) {}

object CaseClass {
  def main(args: Array[String]) = {

    val test = Book("978-0486")
    println(test)
    //when we use normal class both the memory location and values are compared
    //for strings but with case class only values are compared and returns true
    val frank = learnCaseClass("987-123")
    val frank1 = learnCaseClass("987-123")
    println(frank == frank1)
    println("------")

    //below function can take any variable type as input and return any type of variable as output in that cases we can have argument type as Any.

    def matchTest(x: Any): Any = x match {
      case 1 => "one"
      case "two" => 2
      case y: Int => "scala.Int"
      case _ => "many"
    }

    println(matchTest("two"))
    println(matchTest(true))
    println(matchTest(11))
    println("------")

    val alice = Person("Alice", 25)
    val bob = Person("Bob", 32)
    val charlie = Person("Charlie", 32)
    //matching on case classes
    for (person <- List(alice, bob, charlie))
      person match {
        case Person("Alice", 25) => println("Hi Alice!")
        case Person("Bob", 32) => println("Hi Bob!")
        case Person(name, age) => println("Age:" + age + " year, name:" + name + "?")
      }
  }
}