package Functions

/* Created by gouthamkumarreddymeda on 4/15/23 */


  //when we call less promotion within salaryraise then the promotion function is executed
  // by taking the salaries and the function as the input and returns the output list calculated.
  object SalaryRaise extends App {
    private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] = salaries.map(promotionFunction)

    def lessPromotion(salaries: List[Double]): List[Double] = promotion(salaries, salary => salary * 1.1)

    //log returns logarithm of a double value.
    def highPromotion(salaries: List[Double]): List[Double] = promotion(salaries, salary => salary * math.log(salary))

    def hugePromotion(salaries: List[Double]): List[Double] = promotion(salaries, salary => salary * salary)

    println(SalaryRaise.lessPromotion(List(1.2, 3.4, 7.5)))
    println(SalaryRaise.highPromotion(List(1.2, 3.4, 7.5)))
    println(SalaryRaise.hugePromotion(List(1.2, 3.4, 7.5)))

  }

