package oops.classes

class Ctr {
  private var value = 0 //fields must be initialized
  def incr() {
    value = value + 1
  }
  def curr() = value
}

object Ctrrun {
  def main(args: Array[String]) {
    val ctr1 = new Ctr()
    ctr1.incr()
    println(ctr1.curr)
  }
}
