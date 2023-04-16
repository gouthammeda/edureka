
  trait learnedLayeredTraits{
    def log(msg:String){println(msg)}
  }

  trait TimestampLogger extends learnedLayeredTraits{
    override def log(msg:String) {
      println("We are in Timestamp Logger")
      println(new java.util.Date())
      super.log(new java.util.Date()+" "+msg)
    }
  }

  trait ShortLogger extends learnedLayeredTraits{
    val maxLength = 15
    override def log(msg:String): Unit ={
      println("We are in short Logger")
      super.log(if(msg.length<= maxLength) msg
      else msg.substring(0,maxLength-3)+"...")
    }
  }

//class Logging extends TimestampLogger with ShortLogger
class Logging extends ShortLogger
  //class Logging extends ShortLogger with TimestampLogger
  val a = new Logging
  a.log("Logger example")





