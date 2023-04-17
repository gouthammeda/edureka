package oops.constructor


class learnAuxiliaryConstructor(firstname: String, lastName: String, middleName: String) {
  println("Complete Name is " + firstname + lastName + middleName)

  /* Rule1- created using the keyword this
definition of auxiliary constructor is similar to function
*/
  def this(firstname: String) {
    /* Rule2 - In first line of Auxiliary constructor we need to call either primary constructor or
previously defined auxiliary constructor calling is done using this keyword again */
    this(firstname, "", "")
    println("First Name is " + firstname)
  }
    }

object learnAuxConstructor {
  def main(args: Array[String]) {

    //based on number of args passed while creating we make difference in primary and auxiliary constructor calling
    //because of auxiliary constructor we are able to do constructor overloading i.e., passing only first or lastname
    //instead of all the 3 names.
    val a = new learnAuxiliaryConstructor("Ram", "Singh", "Abdul")
    val ab = new learnAuxiliaryConstructor("Ram")
  }
}

