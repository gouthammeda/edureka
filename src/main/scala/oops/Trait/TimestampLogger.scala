package oops.Trait

trait TimestampLogger extends learnedLayeredTraits {
  override def log(msg: String) {
    println(" We are in Timestamp Logger")
    println(new java.util.Date())
    super.log(new java.util.Date() + " " + msg)
  }
}
