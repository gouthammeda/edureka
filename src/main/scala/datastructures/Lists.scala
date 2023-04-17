package datastructures

/* Created by gouthamkumarreddymeda on 4/15/23 */
object Lists {
  def main(args: Array[String]) {
    //List is collection of elements of same data type, they are immutable

    val list = List(1, 2, 3)
    //Nil- End of List
    val ls1 = 1 :: 2 :: 3 :: Nil
    println(ls1)
    val ls2 = List(1, 2.0, 33D, 4000L)
    println(ls2)
    val ls3 = List("foo", 1, 2)
    println(ls3)
    val ls4 = List.fill(3)("foo")
    println(ls4)
    val ls5 = List.range(1, 10)
    println(ls5)
    val ls6 = List.tabulate(5)(n => n * n)
    println(ls6)
    val ls7 = List.tabulate(5)(n => "Edureka" + n)
    println(ls7)

    println("-----")
    //List buffer supports adding elements to it
    import scala.collection.mutable.ListBuffer
    val k = ListBuffer[Int]()
    k += 1
    k += (1, 2, 3, 4, 5)
    println(k)

    var fruits = new ListBuffer[String]()
    fruits += "Apple"
    fruits += ("Strawberry", "Kiwi", "Pineapple")
    fruits -= ("Apple", "Kiwi")
    val fruitsList = fruits.toList
    println(fruitsList)

    println("-----")
    //adding elements to a list
    val tide = List(3)
    val y = 1 :: 2 :: tide
    val z = -1 :: y
    println(z)

    //declare variable as var and re-assign results to it.
    var hi = List(2)
    //:: prepends element to a list.
    hi = 1 :: hi
    hi = -1 :: 0 :: hi
    println(hi)
    println("-----")
    //delete elements from list, we can just filter the elements in a list as it is immutable.
    val original_List1 = List(7, 8, 4, 3, 2)
    val newList = original_List1.filter(_ > 3)
    println(newList)
    //declare variable as var and re-assign results to it.
    var m = List(5, 1, 4, 3, 2)
    m.filter(_ > 3).foreach(println)
    println("-----")
    //merging lists
    val p = List(111, 200, 321)
    val q = List(4, -5, 60)
    val mergeList = p ++ q
    println(mergeList)
    val w = p ::: q
    println(w)
    val g = List.concat(p, q)
    println(g)

    val lst = List(1, 2)
    println(lst.head)
    println(lst.tail)
    println(2 :: List(4, 5))

    println("-----")
    //iterating over a list
    def sum(l: List[Int]): Int = {
      if (l == Nil) 0 else l.head + sum(l.tail)
    }

    println(sum(List(2, 3)))


    // 1st Iteration:
    // 1 + sum(2,3)
    // 2nd:
    // 1 + 2 + sum(3)
    // 3rd:
    // 1+2+3+ sum(List())

  }
}