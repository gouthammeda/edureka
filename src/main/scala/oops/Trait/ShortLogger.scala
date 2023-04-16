package oops.Trait

trait ShortLogger extends learnedLayeredTraits {
  val maxLength = 15

  override def log(msg: String): Unit = {
    println("We are in short Logger")
    super.log(if (msg.length <= maxLength) msg
    else msg.substring(0, maxLength - 3) + "...")
  }
}
