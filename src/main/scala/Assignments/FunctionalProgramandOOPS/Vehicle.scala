package Assignments.FunctionalProgramandOOPS

class Vehicle(speed:Int) {
  val mph:Int = speed
  def race() = println("Racing")
}

class Car(speed:Int) extends Vehicle(speed){
  override val mph:Int = speed
  override def race() = println("Racing Car")
}

class Bike(speed:Int) extends Vehicle(speed){
  override val mph:Int = speed
  override def race() = println("Racing Bike")
}
object Main extends App{
  val vehicle = new Car(200)
  println(vehicle.mph)
  vehicle.race()
  val vehicle2 = new Bike(100)
  println(vehicle2.mph)
}
