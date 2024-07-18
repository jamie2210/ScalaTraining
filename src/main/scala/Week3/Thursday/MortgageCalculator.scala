package Week3.Thursday

object MortgageCalculator extends App{

  case class MortgageInput(mortgage: Int, deposit: Int, creditScore: Int)

  case class MortgageAnswer(mortgage: Int, deposit: String, creditScore: String)

  val flatCost:  Int = 280000

  def calculateMortgage(mortgage: Int): Either[String, Int] = {
    if (mortgage <= 0)
    Left("No mortgage available")
    else
    Right(mortgage  * 4)
  }

  def calculateDeposit(deposit: Int, flatCost: Int): Either [String, String] = {
    if (deposit < (flatCost/10)) Left("I am sorry your deposit must be at least 10% of the flat cost.")
    else Right(s"Great news, your deposit of $deposit is at least 10% of $flatCost")
  }

  def creditCheck(creditScore: Int): Either[String, String] = {
    if (creditScore < 550) Left("I'm sorry your credit score is too low")
    else Right(s"Excellent, your credit score of $creditScore is enough for a mortgage")
  }

  def mortgageChecker(mortgageInput: MortgageInput): Either [String, MortgageAnswer] =
    for {
      mortgage <- calculateMortgage(mortgageInput.mortgage)
      deposit <- calculateDeposit(mortgageInput.deposit, flatCost)
      credit <- creditCheck(mortgageInput.creditScore)
      createMortgageAnswer = MortgageAnswer(mortgage, deposit, credit)
    } yield createMortgageAnswer

  val samantha = MortgageInput(50000, 30000, 600)
  println(mortgageChecker(samantha))

}
