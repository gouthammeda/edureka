package oops
//scala supports single but not multiple inheritance-child class can have one and only one parent class
object Inheritance {

  def main(args: Array[String]) = {
    //Inheritance - we use extends key word to inherit methods of parent class
    class learnInheritance(speed: Int) {
      val mph: Int = speed

      def race() = println("Racing")

      def parentClass() = println("Parent Class")
    }

    class Car(speed: Int) extends learnInheritance(speed) {
      override def race() = println("Racing Car")

      def childClass() = println("Child Class")
    }

    val a = new Car(23)
    a.mph
    a.parentClass()
    a.childClass()
    a.race() // calls child class method

  }
}
