package oops.classes
//case class--> don't need new keyword to instantiate object and don't need a constructor as well.
case class Book(isbn: String){}
case class learnCaseClass(isbn: String){}

object CaseClass {
  def main(args: Array[String]): Unit = {
    val test = Book("978-0486")
    println(test)
    //when we use normal class both the memory location and values are compared
    //for strings but with case class only values are compared and returns true
    val frank = learnCaseClass("987-123")
    val frank1 = learnCaseClass("987-123")
    println(frank == frank1)
  }
}