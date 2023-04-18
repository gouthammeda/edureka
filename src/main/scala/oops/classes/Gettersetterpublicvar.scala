package oops.classes

//classes in scala
// Class - Blueprint
// Object - Instance of a class
// school - For Admission of Child
// Application Form - Class
// Filled Application Form - Object
/* Created by gouthamkumarreddymeda on 4/15/23 */
class Gettersetterpublicvar {
    //getter and setter for public variables
      var var1 = 10
    }

object GetSetpublicVar {
    def main(args:Array[String]) {
        val obj1 = new Gettersetterpublicvar
        obj1.var1 // calling the getter
        obj1.var1 = 13 // calling the setter
        obj1.var1 //-->13
        val obj2 = new Gettersetterpublicvar
        println(obj2.var1) //-->10
    }
}