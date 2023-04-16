package oops.`class`

//classes in scala
// Class - Blueprint
// Object - Instance of a class
// school - For Admission of Child
// Application Form - Class
// Filled Application Form - Object
/* Created by gouthamkumarreddymeda on 4/15/23 */
object classAndGettersetterpublicvar {
  def main(args: Array[String]) {
    //class definition
    class Ctr {
      private var value = 0 //fields must be intialized

      def incr() {
        value = value + 1
      }

      def curr() = value
    }

    val ctr1 = new Ctr
    ctr1.incr()
    print(ctr1.curr)
    println("----")
    //getters and setters in java, but scala creates them by default.
    // public class Duck {
    // 	private int size;
    // 	public int getSize(){return size;}
    // 	public void setSize(int size){
    // 		(if size > 0) this.size = size
    // 	}
    // }

    //getters are used to get the value of variable and setters are used to set the value of variable.
    class Duck {
      var size = 1
    }

    var f = new Duck
    f.size = 10
    f.size_=(10)
    println(f.size)
    //f.size=10 or f.size_
    println("----")
    //getter and setter for public variables
    class learnClass {
      var var1 = 10
    }
    val obj1 = new learnClass
    obj1.var1 // calling the getter
    obj1.var1 = 13 // calling the setter
    obj1.var1 //-->13
    val obj2 = new learnClass
    obj2.var1 //-->10
  }

}
