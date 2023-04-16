package oops.Trait


  class IntIterator(to: Int) extends Iterator[Int] {
    private var current = 0
    override def hasNext: Boolean = current < to
    override def next(): Int = {
      if (hasNext) {
        val t = current
        current += 1
        t
      } else 0
    }
  }

//1st Iteration:
// val t = 0
// current = 1
// 0
//2nd Iteration:
// val t = 1
// current = 2
//1

  object Run {
    def main(args: Array[String]) {
      val iterator = new IntIterator(10)
      iterator.next()
      iterator.next()
    }
  }






