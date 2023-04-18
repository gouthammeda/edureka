package oops
object Hello{
	def main(args:Array[String]) = {
		println("Hello World")
	}
}

//building:
//    sbt
//    package

//spark-submit command
//    spark - submit --
//    class "Hello" -- master yarn / home / gowthambha81edu / HelloWorld / target / scala -2.11 / hello - world_2
//    .11 - 1.0.jar
//    spark - submit --
//    class "Hello" -- master yarn -- executor -memory
//    1 g -- executor -cores
//    1 / home / gowthambha81edu / HelloWorld / target / scala - 2.11 / hello - world_2
//    .11 - 1.0.jar