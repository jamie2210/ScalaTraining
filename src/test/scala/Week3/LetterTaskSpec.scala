package Week3

import Week3.Friday.LetterTask._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class LetterTaskSpec extends AnyWordSpec with Matchers{

  "postcodeOrError" should {
    "go right" when {
      "valid post is entered: SW17 0RZ" in {
        val entry = Postcode.postcodeOrError("SW17 0RZ")
        entry shouldBe Right(Postcode("SW17 0RZ"))
      }
    }
    "go left" when {
      "invalid post is entered: SW170RZ" in {
        val entry = Postcode.postcodeOrError("SW170RZ")
        entry shouldBe Left(InvalidPostageError("Invalid Postcode, please try again"))
      }
    }
   }

  "nameOrError" should {
    "go right" when {
      "name entered without numbers" in {
        val entry = Name.nameOrError("Jamie")
        entry shouldBe Right(Name("Jamie"))
      }
    }
    " go left" when {
      "Name is entered with a number" in {
        val entry = Name.nameOrError("J4mie")
        entry shouldBe Left(InvalidNameError("Invalid Name, please try again"))
      }
    }
  }

  "Letter" should {
    "go right" when {
      "both name and postcode are input correctly" in {
        val entry = Letter.letterOrError("Jamie", "SW17 0RZ")
        entry shouldBe Right(Letter(Name("Jamie"), Postcode("SW17 0RZ")))
      }
    }
    "go left" when {
      "name has a number in it" in {
        val entry = Letter.letterOrError("J4mie", "SW17 0RZ")
        entry shouldBe Left(InvalidNameError("Invalid Name, please try again"))
      }
    }
    "go left" when {
      "postcode does not have a space in it" in {
        val entry = Letter.letterOrError("Jamie", "SW170RZ")
        entry shouldBe Left(InvalidPostageError("Invalid Postcode, please try again"))
      }
    }
    "go left" when {
      "both name and postcode are input incorrectly" in {
        val entry = Letter.letterOrError("J4mie", "SW170RZ")
        entry shouldBe Left(InvalidNameError("Invalid Name, please try again"))
      }
    }
  }

}
