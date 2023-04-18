package oops.classes


//properties with only getters i.e., we are calling incr() method to set the value rather than assigning it
class Counter {
  private var value = 0
  def incr() {
    value += 1
  }
  def current = value
}
object propertieswithonlygetters {
  def main (args: Array[String] ) {
  val c = new Counter ()
  c.incr ()
  c.incr ()
    c.incr()
  c.current
    println(c.current)
  println("---")

  }
}