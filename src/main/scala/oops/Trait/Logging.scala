package oops.Trait

//class Logging extends TimestampLogger with ShortLogger
//1.class Logging extends TimestampLogger with ShortLogger{}
// when we call log method first control goes to short logger which is the right most one and
// executes print statement, next for super.log() execution even-though short logger extends learnedLayeredTraits
//the control is given to timestamp logger and then it executes log method of learnedLayeredTraits.

//output:
//we are in short Logger
//we are in Timestamp Logger
//Tue Oct 18 13:26:33 IST 2022
//DateTime + Logger example


//2.
//class Logging extends ShortLogger{}
//We are in short Logger
//Logger example


//3.
class Logging extends ShortLogger with TimestampLogger{}
//We are in TimestampLogger
//DateTime
//we are in short logger
//Tue Oct 18 1...

object run {
  def main(args: Array[String]) {
    val a = new Logging()
    println(a.log("Hi how are you i am good thanks for asking"))
  }
}