package variablesIfElse

/* Created by gouthamkumarreddymeda on 4/18/23 */
object Ifelse {
  def main(args: Array[String]) {

    //if statement:
    val p = 15;
    if (p < 20) {
      println("This is if statement")
    }
    println("-----")

    //if-else statement:
    val a = 12
    if (a > 10) 1 else 0
    if (a > 10) println("greater than 10") else 0
    println("-----")

    //assigning output of if-else to a value
    val h = 5
    val s = if (h > 0 && h < 6) 1 else 0
    println(s)
    val l = if (h > 0 && h < 6) "positive" else 0
    println(l)

  }
}