package Assignments.FuncsandOOPS

//TODO comeback for this companion object for assigning name two ways

class learnCompanion {
  var name = ""
}

  object learnCompanion {
    def apply(name: String): learnCompanion = {
      var p = new learnCompanion
      p.name = name
      p
    }

    def main(args: Array[String]): Unit = {
      learnCompanion.apply("hai")
      val newName = new learnCompanion()
      newName.name = "hai"
      println(newName.name)
    }
  }
