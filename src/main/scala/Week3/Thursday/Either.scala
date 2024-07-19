package Week3.Thursday

import java.time.LocalDate
import Week3.Friday.Futures.{addition, additionInAFuture}

object Either extends App {

  // Left is usually the error
  // right is usually success
  // Don't assume this as not always the case

  def isEven(x: Int): Either[String, String] =
    if (x%2 == 0) Right(s"$x is even") else Left(s"$x is odd")
  println(isEven(4))
  println(isEven(9))

  // Custom error
  class NewError(val errorCode: Int, val errorMessage: String) extends Exception
  case object IsOddError extends NewError(400, "Bad request in is odd method")

  def isOdd(x: Int): Either[NewError, String] =
    if (x%2 != 0) Right(s"$x is odd") else Left(IsOddError)

  println(isOdd(4)) // expecting error
  println(isOdd(9)) // expecting Right

  /** Try/Catch */

  def plusOne(x: String): Either[String, Int] = {
    try {
      Right{x.toInt}
    } catch {
      case e: Exception => Left(s"Failed due to $e") // wildcard
    }
  }

  println(plusOne("1")) // Right
  println(plusOne("one"))

  // functions directly

//  plusOne("3").map(num => num + 1)
//  plusOne("I will fail").map(num => num + 1) // hit left - will stop


  /** Pattern Matching */
  def plusOneMatch(): Unit = {
    plusOne("one") match {
      case Left(e) => println(s"Left: $e") // come first
      case Right(x) => println(s"Right: $x")
    }
  }
  println(plusOneMatch())

  /** for comps with eithers */
  // fail fast - as soon as one condition is not met = exit

  case class User (username: String, password: String, dateOfBrith: LocalDate)

  case class ValidatedUser (username: String, password: String, dateOfBrith: LocalDate)

  // Validate Username
  def validateUserName(username: String): Either [String, String] = {
    if (username.length < 12) Left("Username must be at least 12 characters") else
      Right(username)
  }

  // Validate Password
  def validatePassword(password: String): Either[String, String] = {
    if (password.toUpperCase == password || password.toLowerCase == password) Left("Password must made up of upper and lower case") else
      Right(password)
  }

  // Validate Age
  def validateAge(dateOfBirth: LocalDate): Either[String, LocalDate] = {
    if (dateOfBirth.plusYears(18).isAfter(LocalDate.now)) Left("User must be 18 years old") else
      Right(dateOfBirth)
  }

  // Combine all 3, validate whole user
  def validateUser(user: User): Either[String, ValidatedUser] =
    for {
      username <- validateUserName(user.username)
      password <- validatePassword(user.password)
      age <- validateAge(user.dateOfBrith)
      createValidatedUser = ValidatedUser(username, password, age) // creating case class of validate user
    } yield createValidatedUser // will only yield if all methods above hit Right

  val usernameBad = User("Jamie", "fdeGBG", LocalDate.of(1990, 5, 12))
  val passwordBad = User("JamieAndrewLetts", "ffff", LocalDate.of(1990, 5, 12))
  val ageBad = User("JamieAndrewLetts", "fdeGBG", LocalDate.of(2019, 5, 12))
  val usernameGood = User("JamieAndrewLetts", "fdeGBG", LocalDate.of(1970, 5, 12))

  println(validateUser(usernameBad)) // Left(Username must be at least 12 characters)
  println(validateUser(passwordBad)) // Left(Password must mae up of upper and lower case)
  println(validateUser(ageBad)) // Left(Username must be at least 12 characters)
  println(validateUser(usernameGood)) // Right(ValidatedUser(JamieAndrewLetts,fdeGBG,1970-05-12))

}
