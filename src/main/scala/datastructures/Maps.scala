package datastructures

/* Created by gouthamkumarreddymeda on 4/15/23 */
object Maps {

  def main(args: Array[String]) {
    //Maps:
    val mapping = Map("Vishal" -> "Kumar", "Vijay" -> "Verma")
    val mapping1 = Map("Dave" -> "Rosserio", "Harry" -> "Williams")
    //print keys and values from a map.
    mapping1.keys.foreach { i =>
      println(i + " " + mapping1(i))
    }
    //searching for key:
    println(mapping.contains("Harry"))

    val map1 = Map(1 -> "Finance", 2 -> "Dispatch", 3 -> "operations")
    println(map1(1))
    val map2 = Map(1 -> "Finance", 2 -> "Dispatch", 3 -> "operations", 2 -> "Store")
    println(map2(2))
    val map3 = Map(1 -> "Finance", 2 -> "Dispatch", 3 -> "Dispatch")
    println(map3(2))
    //map3(4)
    println(map3.getOrElse(4, "ValueNotFound"))
    println(map3.getOrElse(1, "ValueNotFound"))
  }
}