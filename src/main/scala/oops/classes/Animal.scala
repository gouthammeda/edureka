package oops.classes

import oops.Trait.{HasLegs, Philosophical}

class Animal {}
//using with to extend multiple traits
class Frog extends Animal with Philosophical with HasLegs{
  override def toString = "green"
}

object Frogrun {
  def main(args: Array[String]) {
    val f = new Frog()
    f.toString
  }
}
