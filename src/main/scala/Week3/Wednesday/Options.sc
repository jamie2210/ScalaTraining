
trait Pizza {
  val size: Int
  val crust: Option[String]
}

object Personal extends Pizza {
  val size: Int = 7
  val crust: Option[String] = None
}

object smallClassic extends Pizza {
  val size = 9
  val crust = Some("Classic")
}

object smallItalian extends Pizza {
  override val size: Int = 9
  override val crust: Option[String] = Some("italian")
}

val pizzaOrder: Pizza = new Pizza {
  override val size: Int = 9
  override val crust: Option[String] = Some("Stuffed")
}

def whatCrust(pizza: Pizza): String = {
  pizza.crust match {
    case Some("classic") => "Classic Crust"
    case Some("italian") => "Italian Crust"
    case Some("stuffed") => "Stuffed Crust"
    case Some(x) => s"$x is not a valid crust"
    case None => "Default crust - classic"
  }
}
whatCrust(pizzaOrder)

// .get
val getCrust: String = pizzaOrder.crust.get

// .gerOrElse (default to be given)
val getOrElseCrust: String = pizzaOrder.crust.getOrElse("classic")

trait chocolateBar {
  val filling: Option[String]
}

object Mars extends chocolateBar {
  val filling: Option[String] = Some("Nougat")
}

object DairyMilk extends chocolateBar {
  val filling: Option[String] = None
}

object Snickers extends chocolateBar {
  val filling: Option[String] = Some("Nuts & Caramel")
}

val selectedBar: chocolateBar = new chocolateBar {
  override val filling: Option[String] = Some("Nougat")
}

def whatBar(bar: chocolateBar): String = {
  bar.filling match {
    case Some("Nougat") => "Mars has a tasty filling"
    case Some("Nuts & Caramel") => "Snickers is top notch"
    case Some(x) => s"$x is not a valid filling"
    case None => "Default - Dairy Milk"
  }
}

val getBar: String = selectedBar.filling.getOrElse("Nougat")
whatBar(Snickers)