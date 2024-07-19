package Week3.Friday

object VinnieAfternoonTask extends App {

  // create two case classes 'Name' and Postcode - value string
  case class Name(value: String)
  case class Postcode(value: String)

  // Create a case class called Letter' that contains a name' and postcode
  //  - The 'name' should have the type 'Name'
  //  - The postcode should have the type
  case class Letter(name: Name, postcode: Postcode)

  //  Create a trait called 'GenericPostageError'
  //  - Give it a parameter method 'message' with a type "String'
  trait GenericPostageError {
    def message: String
  }
  //  Create a case class called 'Invalid NameError'
  //  - Give it a parameter message with a type String'
  //  - Let it be extended by 'GenericPostageError'
  case class InvalidNameError(message: String) extends GenericPostageError

  //  Create a case class called InvalidPostcodeError
  //  - Give it a parameter message with a type "String'
  //  - Let it be extended by GenericPostageError
  case class InvalidPostcodeError(message: String) extends GenericPostageError

  //  Create the following variables that have a type
  //  'Either[GenericPostageError, Letter]'
  //  - val letter : A letter constructed using the 'apply' method of 'Letter'
  //  - 'val invalidLetter': An error constructed using the '.apply' method of
  //  "InvalidNameError first

  val letter: Right[Nothing, Letter] =
    Right(Letter(name = Name("Jon"), postcode = Postcode("SW17 9TA")))

  val invalidLetter: Left[InvalidNameError, Nothing] =
    Left(InvalidNameError("Invalid name provided"))

  // Print the values to see if they are 'Right' or 'Left'
  println(s"letter: $letter")
  println(s"invalidLetter: $invalidLetter")

  object Postcode {
    def postcodeOrError(maybePostCode: String): Either[InvalidPostcodeError, Postcode] = {
      val postcodePattern = """^\S+\s+\S+$""".r
      if (postcodePattern.matches(maybePostCode)) Right(Postcode(maybePostCode)) else
        Left(InvalidPostcodeError(s"Invalid postcode: $maybePostCode"))
    }
  }

  object Name {
    def nameOrError(mayBeName: String): Either[InvalidNameError, Name] = {
      if (mayBeName.exists(_.isDigit)) Left (InvalidNameError(mayBeName)) else
        Right(Name(mayBeName))

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

  val letterWithANumberInName: Either[GenericPostageError, Letter] =
    Letter.letterOrError("J4mie", "sw17 9TA")

  val letterWithAnInvalidPostcode: Either[GenericPostageError, Letter] =
    Letter.letterOrError("Jamie", "SW179TA")

  val letterAllInvalid: Either[GenericPostageError, Letter] =
    Letter.letterOrError("Jamie", "SW17 9TA")

  // Print the results
  println(s"letterWithANumberInName: $letterWithANumberInName")
  println(s"letterWithAnInvalidPostcode: $letterWithAnInvalidPostcode")
  println(s"letterAllInvalid: $letterAllInvalid")
}
