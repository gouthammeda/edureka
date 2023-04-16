package oops.`class`

object propertieswithonlygetters {

  def main (args: Array[String] ) {
  //properties with only getters i.e., we are calling incr() method to set the value rather than assigning it
  class Counter {
    private var value = 0
    def incr() {
      value += 1
    }
    def current = value
  }

  val c = new Counter ()
  c.incr ()
  c.incr ()
  c.current
  println("---")

  class learnClass {
    var value = 0

    def incr() {
      value += 1
    }

    def curr() = value
  }

  val obj1 = new learnClass
  obj1.incr ()
  obj1.incr ()
  obj1.incr ()
  obj1.incr ()
  obj1.curr ()
  val obj2 = new learnClass
  obj2.incr ()
  obj2.curr ()

  }
}