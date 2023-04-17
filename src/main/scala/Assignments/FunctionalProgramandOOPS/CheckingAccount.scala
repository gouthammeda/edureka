package Assignments.FunctionalProgramandOOPS

class AccountInformation (initBal:Double){
  private var balance = initBal
  def deposit (amount:Double)={
    balance +=amount;
    balance = balance - 1
    println("amount deposit with charge $1 "+balance)
  }
  def withdraw(amount:Double)={
    balance -= amount;
    balance = balance - 1
    println("amount withdraw with charge $1 "+balance)
  }
}
object CheckingAccount{
  def main(arr:Array[String])={
    val balance = 1000
    var Acct = new AccountInformation(balance)
    Acct.deposit(100)
    Acct.withdraw(150)
  }
}