package Week3.Friday

object VinnieAfternoonTask extends App {

  case class Name(value: String)
  case class Postcode(value: String)

  case class Letter(name: Name, postcode: Postcode)

  trait GenericPostageError {
    def message: String
  }

  case class InvalidNameError(message: String) extends GenericPostageError

  case class InvalidPostcodeError(message: String) extends GenericPostageError

  val letter: Right[Nothing, Letter] =
    Right(Letter(name = Name("Jon"), postcode = Postcode("SW17 9TA")))

  val invalidLetter: Left[InvalidNameError, Nothing] =
    Left(InvalidNameError("Invalid name provided"))

  object Postcode {
    def postcodeOrError(maybePostCode: String): Either[InvalidPostcodeError, Postcode] = {
      val postcodePattern = """^\S+\s+\S+$""".r
      if (postcodePattern.matches(maybePostCode)) Right(Postcode(maybePostCode)) else Left(InvalidPostcodeError(s"Invalid postcode: $maybePostCode"))
    }
  }

  object Name {
    def nameOrError(maybeName: String): Either[InvalidNameError, Name] = {
      if (maybeName.exists(_.isDigit)) Left(InvalidNameError(s"Invalid name: $maybeName")) else
        Right(Name(maybeName))
    }
  }

  object Letter {
    def letterOrError(maybeName: String, maybePostCode: String): Either[GenericPostageError, Letter] = {
    for {
      name <- Name.nameOrError(maybeName)
      postcode <- Postcode.postcodeOrError(maybePostCode)
    } yield Letter(name, postcode)
    }
  }
}
