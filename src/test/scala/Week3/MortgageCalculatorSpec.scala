package Week3

import Week3.Thursday.MortgageCalculator._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class MortgageCalculatorSpec extends AnyWordSpec with Matchers {

  "calculateMortgage" should {
    "return right" when {
      "number is greater than 0" in {
        val result = calculateMortgage(2)
        result shouldBe Right(8)
      }
    }
    "return left" when {
      "number is equal to or less than 0" in {
        val result = calculateMortgage(0)
        result shouldBe Left("No mortgage available")
      }
    }
  }

  "calculateDeposit" should {
    "return right" when {
      "deposit is higher than 10% of flat price" in {
        val result = calculateDeposit(5, 20)
        result shouldBe Right("Great news, your deposit of 5 is at least 10% of 20")
      }
    }
    "return left" when {
      "deposit is lower than 10% if flat price" in {
        val result = calculateDeposit(1, 20)
        result shouldBe Left("I am sorry your deposit must be at least 10% of the flat cost.")
      }
    }
  }

  "creditCheck" should {
    "return right" when {
      "credit score is above 550" in {
        val result = creditCheck(600)
        result shouldBe Right(s"Excellent, your credit score of 600 is enough for a mortgage")
      }
    }
    "return left" when {
      "credit score is below 550" in {
        val result = creditCheck(500)
        result shouldBe Left("I'm sorry your credit score is too low")
      }
    }
  }
  "mortgageChecker" should {
    "return a right" when {
      "all inputs pass" in {
        val user = MortgageInput(50000, 30000, 600)
        mortgageChecker(user) shouldBe Right(MortgageAnswer(
          200000,
          "Great news, your deposit of 30000 is at least 10% of 0",
          "Excellent, your credit score of 600 is enough for a mortgage"
        )
        )
      }
    }
    "return a left" when {
      "mortgage is 0 or below" in {
        val user = MortgageInput(0, 30000, 600)
        mortgageChecker(user) shouldBe Left("No mortgage available")
      }
    }
    "return a left" when {
      "deposit is at least 10% of flat cost" in {
        val user = MortgageInput(50000, -1, 600)
        mortgageChecker(user) shouldBe Left("I am sorry your deposit must be at least 10% of the flat cost.")
      }
    }
    "return a left" when {
      "credit is less that 550t" in {
        val user = MortgageInput(50000, 30000, 500)
        mortgageChecker(user) shouldBe Left("I'm sorry your credit score is too low")
      }
    }
  }
}
