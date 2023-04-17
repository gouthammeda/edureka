package oops.constructor


    //primary constructor checks if correct number of arguments are given to the class
    //and executes all the statements inside the class.
    class learnPrimaryConstructor(firstname: String, lastName: String, middleName: String){
    println(firstname + ' ' + lastName + ' ' + middleName)

    def first() {
      println(firstname)
    }

    def middle() {
      println(middleName)
    }

    def last() {
      println(lastName)
    }

    first()
    middle()
    last()
    }


object primaryConstructor {
  def main(args: Array[String]): Unit = {
    val pl = new learnPrimaryConstructor("Ram", "Singh", "abdul")

  }
  }