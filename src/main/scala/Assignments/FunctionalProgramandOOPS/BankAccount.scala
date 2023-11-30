package Assignments.FunctionalProgramandOOPS
object BankAccount{
class AccountInfo(initBal:Double) {
  private var balance = initBal
  def deposit(amount: Double): Unit = {
    balance += amount
    println("Amount Deposit " + balance)
  }

  def withdraw(amount: Double) = {
    balance -= amount
    println("Amount Withdraw " + balance)
  }
}

    val balance = 1000.00
    def main(args:Array[String]): Unit ={
      var Acct = new AccountInfo(balance)
      Acct.deposit(100)
      Acct.withdraw(150)
    }
  }



