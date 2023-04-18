package oops.classes

//getter and setter for private variable
class DuckPrivateVar {
  private var privateAge = 0
  def age = privateAge
  def age_=(newAge: Int) {
    if (newAge > privateAge) privateAge = newAge;
  }
}

class learnClass {
  private var var1 = 10
  def custGetter() = var1 //customized getter
  def custSetter(x: Int) {
    var1 = x
  } //customized setter
}

object gettersetterPrivateVariable {
  def main(args: Array[String]) {
    var d = new DuckPrivateVar
    d.age = 34
    d.age_=(34)
    println(d.age)
    println("---")
    val obj1 = new learnClass
    obj1.custGetter()
    obj1.custSetter(13)
    println(obj1.custGetter())
  }
}