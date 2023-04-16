package oops.`object`

/* Created by gouthamkumarreddymeda on 3/19/23 */
object learnSingletonObject extends  App {
  //singletons--> scala doesn't have static members so it has singleton objects
  //SingleTon Object is special type of class created using object keyword
  //we don't have to create a class and then create instance of that class
    var lastNum = 0
    def newReservation() = {
      lastNum += 1;
      lastNum
    }

  learnSingletonObject.newReservation()
  learnSingletonObject.newReservation()
  learnSingletonObject.newReservation()
  learnSingletonObject.newReservation()
  learnSingletonObject.newReservation()

}
