def apply(x: Int, xs: Int*): Array[Int] = {
  val array = new Array[Int](xs.length + 1)
  array(0) = x
  val iterator = xs.iterator
  var i = 1
  while (iterator.hasNext) {
    array(i) = iterator.next();
    i += 1
  }
  array
}
println(apply(5, 1, 7, 8, 9, 6))