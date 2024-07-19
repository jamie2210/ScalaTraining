package Week3

import Week3.Friday.VinnieAfternoonTask._
//import Week3.Friday.VinnieAfternoonTask.{InvalidNameError, Letter, Name, Postcode}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class VinnieAfternoonTaskSpec extends AnyWordSpec with Matchers {

    "Name" should {
      "create a letter" in {
        val letter: Right[Nothing, Letter] =
          Right(Letter(name = Name("Jon"), postcode = Postcode("SW17 9TA")))

        letter shouldBe (Right(Letter(Name("Jon"),Postcode("SW17 9TA"))))
      }
      "return an invalid error" in {
        val invalidLetter: Left[InvalidNameError, Nothing] =
          Left(InvalidNameError("Invalid name provided"))

        invalidLetter shouldBe Left(InvalidNameError("Invalid name provided"))
      }
    }

  "Postcode" should {
    "return a valid postcode" in {
      val result = Postcode.postcodeOrError("SW17 0RZ")
      result shouldBe (Right(Postcode("SW17 0RZ")))
    }
    "return error message" in {
      val result = Postcode.postcodeOrError("SW170RZ")
      result shouldBe (Left(InvalidPostcodeError("Invalid postcode: SW170RZ")))
    }
  }

  "Name" should {
    "return a valid name" in {
      val result = Name.nameOrError("Jamie")
      result shouldBe (Right(Name("Jamie")))
    }
  }
  "return error message" in {
    val result = Name.nameOrError("J4mie")
    result shouldBe (Left("Invalid name: J4mie"))
  }

  "Letter" should {
    "return a right" when {
      "all inputs pass" in {
        val inputs = Letter.letterOrError("Jamie", "SW17 9TA")
        inputs shouldBe Right(Letter(Name("Jamie"),Postcode("SW17 9TA")))
      }
      "return a left" when {
        "name input is invalid" in {
          val inputs = Letter.letterOrError("J4mie", "SW17 9TA")
          inputs shouldBe Left(InvalidNameError("Invalid name: J4mie"))
        }
        "postcode input is invalid" in {
          val input = Letter.letterOrError("Jamie", "SW179TA")
          input shouldBe Left(InvalidPostcodeError("Invalid postcode: SW179TA"))
        }
        "either name or postcode are invalid" in {
          val input = Letter.letterOrError("J4mie", "SW179TA")
          input shouldBe Left(InvalidNameError("Invalid name: J4mie"))
        }
      }
    }
  }
}
