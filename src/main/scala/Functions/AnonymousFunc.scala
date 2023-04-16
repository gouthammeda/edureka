package Functions

/* Created by gouthamkumarreddymeda on 4/15/23 */
object AnonymousFunc {
  def main(args:Array[String]) {
    val str = "abc"
    println(str)
    //instead of defining functions with def and name we write it as literals which are known as anonymous functions.
    //function that raises its argument to a cube.
      (x: Int) => x * x * x
      (x: Int, y: Int) => x + y

        def sum(f: Int => Int, a: Int, b: Int): Int = {
          if (a > b) 0 else f(a) + sum(f, a + 1, b)
        }
        def sumInts(a: Int, b: Int) = sum(x => x, a, b)
        def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)
        println(sumInts(2,3))
        println(sumCubes(4,5))

        //below function takes two args ssl and domainName as input and returns a anonymous function
        def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
          val schema = if (ssl) "https://" else "http://"
          //below is an anonymous function which takes two strings and return a string
          (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
        }

        val domainName = "www.example.com"
        def getURL = urlBuilder(ssl = true, domainName)
        val endpoint = "users"
        val query = "id=1"
        val url = getURL(endpoint, query)
        println(url)
  }
}
