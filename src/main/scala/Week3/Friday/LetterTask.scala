package Week3.Friday

import Week3.Friday.LetterTask.Letter

object LetterTask extends App{

  case class Name(Value: String)
  case class Postcode(Value: String)

  case class Letter(name: Name, postcode: Postcode)

  trait GenericPostageError {
    def message: String
  }

  case class InvalidNameError(message: String) extends GenericPostageError
  case class InvalidPostageError(message: String) extends GenericPostageError

  val letter:Right[GenericPostageError, Letter] =
    Right(Letter(name = Name("David"), postcode = Postcode("SW17 0TT")))

  val invalidLetter: Left[InvalidNameError, Nothing] =
    Left(InvalidNameError("Invalid name provided"))

  println(letter)
  println(invalidLetter)

  object Postcode {
    def postcodeOrError(maybePostcode: String): Either[InvalidPostageError, Postcode] = {
      val postcodeEntry = """^\S+\s+\S+$""".r
      if (postcodeEntry.matches(maybePostcode)) Right(Postcode(maybePostcode))
      else Left(InvalidPostageError("Invalid Postcode, please try again"))
    }
  }

  object Name {
    def nameOrError(maybeName: String): Either[InvalidNameError, Name] = {
      if (maybeName.exists(_.isDigit)) Left(InvalidNameError("Invalid Name, please try again"))
      else Right(Name(maybeName))
    }
  }

  object Letter {
    def letterOrError(maybeName: String, maybePostcode: String): Either[GenericPostageError, Letter] = {
      for {
        name <- Name.nameOrError(maybeName)
        postcode <- Postcode.postcodeOrError(maybePostcode)
      } yield Letter(name, postcode)
    }
  }
  val letterWithANumber = Letter.letterOrError("J4mie", "SW17 0RZ")
  val letterWithInvalidPostcode = Letter.letterOrError("Jamie", "SW170RZ")
  val correctLetter = Letter.letterOrError("Jamie", "SW17 0RZ")

  println(letterWithANumber)
  println(letterWithInvalidPostcode)
  println(correctLetter)
}


