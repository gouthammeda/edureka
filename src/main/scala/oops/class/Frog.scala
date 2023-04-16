package oops.`class`

import oops.Trait.Philosophical
import oops.Trait.HasLegs

//using with to extend multiple traits
class Frog extends Animal with Philosophical with HasLegs{
  override def toString = "green"
}

object run {
  def main(args: Array[String]) {
    val f = new Frog()
    f.toString
  }
}
