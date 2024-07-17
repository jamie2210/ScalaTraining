// Match of val

val weather: String = "Rain"

if (weather == "cold") {
  println("Take a coat")
} else if (weather == "rain") {
  println("Take an umbrella")
} else {
  print("Take nothing")
}

weather.toLowerCase() match {
  case "cold" => println("Take a coat")
  case "rain" => println("Take an umbrella")
  case _ => println{s"$weather is not valid"}
}

// Match of int
val numOfWatermelons: Int = 0
numOfWatermelons match {
  case x if x <= 0 => println("Must be more than zero")
//  case 0 => println("Must be more than 0")
  case 1 | 2 | 3 => println("John can carry these without a bag")
  case 4 | 5 => println("John needs a bag")
  case _ => println(s"$numOfWatermelons is invalid")

}

// if guard - be careful of ordering

// Matching off objects
sealed trait Temperature // can only be extended within the same file that it is defined in
object Cold extends Temperature
object Hot extends Temperature
object Mild extends Temperature

val weather: Temperature = Hot

weather match {
  case Cold => "Take a coat"
  case Hot => "Wear suncream"
  case Mild => "Shorts?!"
  case _ => "Not valid"
}

// Matching using classes

abstract class Notification // Cannot be instantiated - must be extended.

case class Email (sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification

val notification: Notification = SMS("Mum", "Are you home?")

notification match {
  case Email(sender, title, body) => "Email from " + sender + " Title: " + title
  case SMS(caller, message) if caller == "Mum" => "SMS from " + caller + ". don't ignore"
  case SMS(caller, message) => "New message from " + caller
  case VoiceRecording(contactName, link) => "New voice note from " + contactName + " Click here: " + link
  case _ => "Not valid"
}



sealed trait Topping

object Spicy extends Topping
object Veggie extends Topping
object BBQ extends Topping

val pizza: Topping = Veggie

val pizzaDescription: String = pizza match {
  case Spicy => "Nduja Pepperoni"
  case Veggie => "Veggie Supreme"
  case BBQ => "Texas Chicken"
  case _ => "Not valid"
}

sealed trait Crust

object Classic extends Crust
object Italian extends Crust
object stuffed extends Crust

/**
 * 7 = Personal (£5.99)
 * 9 = Small (£10.99)
 * 11 = Medium (£12.99)
 * 14 = Large (£14.99)
 */

case class PizzaOrder(size: Int, crust: Crust)

