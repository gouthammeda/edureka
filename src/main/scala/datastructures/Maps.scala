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
    mapping1.contains("Harry")

    val map1 = Map(1 -> "Finance", 2 -> "Dispatch", 3 -> "operations")
    map1(1)
    val map2 = Map(1 -> "Finance", 2 -> "Dispatch", 3 -> "operations", 2 -> "Store")
    val map3 = Map(1 -> "Finance", 2 -> "Dispatch", 3 -> "Dispatch")
    map3(2)
    map3(3)
    //map3(4)
    map3.getOrElse(4, "ValueNotFound")
    map3.getOrElse(3, "ValueNotFound")
    map3.getOrElse(1, "ValueNotFound")
  }
}