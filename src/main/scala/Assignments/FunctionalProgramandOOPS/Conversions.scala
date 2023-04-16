package Assignments.FunctionalProgramandOOPS

object Conversions {

  def main(args: Array[String]): Unit = {
    //inch -> divide it with 12
    //mile -> multiply with 1.609
    //pound -> divide it with 2.205

    def inchestoFeet(inch: Int) = { inch * 0.08 }
    def milestoKms(miles: Int) = { miles * 1.609 }
    def poundsToKilos(pounds: Int) = {pounds % 2.2}

    val Feet = inchestoFeet(5)
    println(Feet)
    val km = milestoKms(3)
    println(km)
    val kilos = poundsToKilos(2)
    println(kilos)

  }
}