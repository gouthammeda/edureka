package Assignments.FunctionalProgramandOOPS

object SalaryRaise{
  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] = salaries.map(promotionFunction)
  def lessPromotion(salaries: List[Double]): List[Double] = promotion(salaries, salary => salary * 1.1)
  def highPromotion(salaries: List[Double]): List[Double] = promotion(salaries, salary => salary * math.log(salary))
  def hugePromotion(salaries: List[Double]): List[Double] = promotion(salaries, salary => salary * salary)
}
