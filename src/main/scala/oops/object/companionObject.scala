package oops.`object`

//companion objects-> when singleton object shares same name with a class it is called that class's companion object.
//both class and companion object must be in the same source file
//TODO complete it
object companionObject {

  def main(args: Array[String]) {
    class Account {
      val id = Account.newNum()
      private var bal = 0.0
    }

    object Account {
      private var lastNum = 0

      private def newNum() = {
        lastNum += 1;
        lastNum
      }
    }

    // val checking = new Account()
    // println(checking.id)


    //companion objects --> within a same file we can contain both class and object
    //they exchange each others private members
    //try making this work
    class learnCompanion {
      var name = ""
    }

    object learnCompanion {
      def apply(name: String): learnCompanion = {
        var p = new learnCompanion
        p.name = name
        p
      }
    }

    val arr1 = Array(1, 2, 3, 4, 5)
    val arr2 = new Array[Int](4)

    //using apply method in array companion object we can create and initialize
    //elements in array which internally does 2nd type above
    def apply(x: Int, xs: Int*): Array[Int] = {
      val array = new Array[Int](xs.length + 1)
      array(0) = x
      val iterator = xs.iterator
      var i = 1
      while (iterator.hasNext) {
        array(i) = iterator.next();
        i += 1
      }
      array
    }

    apply(5, 1, 7, 8, 9, 6)

  }
}
