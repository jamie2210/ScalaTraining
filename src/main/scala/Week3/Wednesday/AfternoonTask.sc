/** MVP */
// 1.

val country: String = "    "

country.toLowerCase.trim match {
  case x if x == "" => println("You must enter something")
  case "england" => println(s"${country.trim}'s capital is London")
  case "france" => println(s"${country.trim}'s capital is Paris")
  case "italy" => println(s"${country.trim}'s' capital is Milan")
  case _ => println(s"${country.trim} is not a valid option")
}

// 2.

import java.time.LocalDate
import java.time.temporal.ChronoUnit

case class Person (
                  fullName: String,
                  dob: String,
                  age: Option[Int],
                  starSign: String,
                  occupation: Option[String],
                  lastCountryRes: String,
                  dateOfDeath: Option[String],
                  ageAtDeath: Option[Int],
                  )

def createPerson(
                  fullName: String,
                  dob: String,
                  age: Option[Int],
                  starSign: String,
                  occupation: Option[String],
                  lastCountryRes: String,
                  dateOfDeath: Option[String],
                  ageAtDeath: Option[Int]
                ): Person = {

  Person(fullName, dob, age, starSign, occupation , lastCountryRes, dateOfDeath, ageAtDeath)
}

val jamie = createPerson("Jamie Letts", "22/10/1983", Some(40), "Libra",  None, "UAE", None, None)
val trevor = createPerson("Trevor Nelson", "13/04/1971", Some(53), "Aries", Some("DJ"), "France", None, None)
val tracy = createPerson("Tracy Gibbons", "01/03/1873", None, "Pisces", Some("Nurse"), "England", Some("1949"), Some(76))

println(jamie, trevor, tracy)