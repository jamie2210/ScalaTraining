import java.time.{LocalDate, MonthDay}

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

case class Person (
                  fullName: String,
                  dob: LocalDate,
                  age: Option[Int],
                  occupation: Option[String],
                  lastCountryRes: String,
                  dateOfDeath: Option[LocalDate],
                  ageAtDeath: Option[Int],
                  )

def createPerson(
                  fullName: String,
                  dob: LocalDate,
                  age: Option[Int],
                  occupation: Option[String],
                  lastCountryRes: String,
                  dateOfDeath: Option[LocalDate],
                  ageAtDeath: Option[Int]
                ): Person = {

  Person(fullName, dob, age, occupation , lastCountryRes, dateOfDeath, ageAtDeath)
}

val jamie = createPerson("Jamie Letts", LocalDate.of(1983, 10, 22), Some(40),  None, "UAE", None, None)
val trevor = createPerson("Trevor Nelson", LocalDate.of(1971, 4, 13), Some(53), Some("DJ"), "France", None, None)
val tracy = createPerson("Tracy Gibbons", LocalDate.of(1873, 3, 1), None, Some("Nurse"), "England", Some(LocalDate.of(1949, 1, 17)), Some(76))

println(jamie)

def horoscope(dob: LocalDate): (String, String) = {
  val (month, day) = (dob.getMonthValue, dob.getDayOfMonth)
  println(s"Month: $month, Day: $day")

  val starSign = (month, day) match {
    case (1, day) if day <= 19 => "Capricorn"
    case (1, day) if day >= 20 => "Aquarius"
    case (2, day) if day <= 18 => "Aquarius"
    case (2, day) if day >= 19 => "Pisces"
    case (3, day) if day <= 20 => "Pisces"
    case (3, day) if day >= 21 => "Aries"
    case (4, day) if day <= 19 => "Aries"
    case (4, day) if day >= 20 => "Taurus"
    case (5, day) if day <= 20 => "Taurus"
    case (5, day) if day >= 21 => "Gemini"
    case (6, day) if day <= 20 => "Gemini"
    case (6, day) if day >= 21 => "Cancer"
    case (7, day) if day <= 22 => "Cancer"
    case (7, day) if day >= 23 => "Leo"
    case (8, day) if day <= 22 => "Leo"
    case (8, day) if day >= 23 => "Virgo"
    case (9, day) if day <= 22 => "Virgo"
    case (9, day) if day >= 23 => "Libra"
    case (10, day) if day <= 22 => "Libra"
    case (10, day) if day >= 23 => "Scorpio"
    case (11, day) if day <= 21 => "Scorpio"
    case (11, day) if day >= 22 => "Sagittarius"
    case (12, day) if day <= 21 => "Sagittarius"
    case (12, day) if day >= 22 => "Capricorn"
    case _ => "Invalid date"
  }

  val horoscopeMessage = starSign match {
    case "Aquarius" => "Innovation will bring you joy"
    case "Pisces" => "Your intuition is strong today."
    case "Aries" => "Today is a great day to start something new."
    case "Taurus" => "You will find comfort in familiar places."
    case "Gemini" => "Communication is key today."
    case "Cancer" => "You might feel more emotional today."
    case "Leo" => "Your confidence will shine through."
    case "Virgo" => "Pay attention to the details."
    case "Libra" => "Balance is important today."
    case "Scorpio" => "Your determination will pay off."
    case "Sagittarius" => "Adventure awaits you."
    case "Capricorn" => "Hard work will lead to success."
    case _ => "Error: no horoscope available."
  }

  (starSign, horoscopeMessage)
}

def getHoroscope (person: Person): (String, String) = {
  val (month, day) = (person.dob.getMonthValue, person.dob.getDayOfMonth)
  horoscope(person.dob)
}

println(s"${trevor.fullName}'s date of birth: ${trevor.dob}")
val trevorHoroscope = getHoroscope(trevor)

println(s"Trevor's Star Sign is ${trevorHoroscope._1}: ${trevorHoroscope._2}")


//case "Aquarius" => "Innovation will bring you joy"
//case "Pisces" => "Your intuition is strong today."
//case "Aries" => "Today is a great day to start something new."
//case "Taurus" => "You will find comfort in familiar places."
//case "Gemini" => "Communication is key today."
//case "Cancer" => "You might feel more emotional today."
//case "Leo" => "Your confidence will shine through."
//case "Virgo" => "Pay attention to the details."
//case "Libra" => "Balance is important today."
//case "Scorpio" => "Your determination will pay off."
//case "Sagittarius" => "Adventure awaits you."
//case "Capricorn" => "Hard work will lead to success."
//case _ => "Error: no horoscope available."