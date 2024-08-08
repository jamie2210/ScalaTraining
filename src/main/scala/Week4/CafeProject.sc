/** Testing MVP branch */
// Jamie update

sealed trait ColdDrinks

object ColdDrinks {
  case object Coke extends ColdDrinks
  case object Sprite extends ColdDrinks
  case object Beer extends ColdDrinks
  case object Cocktail extends ColdDrinks

}


case class MENU(drink: ColdDrinks)

// Example usage
val cokeMenu = MENU(ColdDrinks.Coke)
val spriteMenu = MENU(ColdDrinks.Sprite)
val beerMenu = MENU(ColdDrinks.Beer)
val cocktailMenu = MENU(ColdDrinks.Cocktail)





sealed trait ItemQuality

object ItemQuality {
  case object Standard extends ItemQuality
  case object Premium extends ItemQuality
}

sealed trait ItemType

object ItemType {
  case object ColdDrink extends ItemType
  case object HotDrink extends ItemType
  case object ColdFood extends ItemType
  case object HotFood extends ItemType
}

case class Menu(
                 name: String,
                 Price: Double,
                 itemQuality: ItemQuality,
                 itemType: ItemType
               )

object Menu {

  val standardItems: List[Menu] = List(
    Menu("Coke", 1.50, ItemQuality.Standard, ItemType.ColdDrink),
    Menu("Sprite", 1.50, ItemQuality.Standard, ItemType.ColdDrink),
    Menu("Beer", 7.50, ItemQuality.Standard, ItemType.ColdDrink),
    Menu("Cocktail", 12.50, ItemQuality.Standard, ItemType.ColdDrink),
    Menu("Latte", 4.75, ItemQuality.Standard, ItemType.HotDrink),
    Menu("Americano", 4.00, ItemQuality.Standard, ItemType.HotDrink),
    Menu("Breakfast Tea", 3.75, ItemQuality.Standard, ItemType.HotDrink),
    Menu("Green Tea", 3.75, ItemQuality.Standard, ItemType.HotDrink)
  )

  val premiumItems: List[Menu] = List(
    Menu("Stella", 1.50, ItemQuality.Premium, ItemType.ColdDrink),
    Menu("Pin Colada", 1.50, ItemQuality.Premium, ItemType.ColdDrink),
    Menu("Red Wine", 3.00, ItemQuality.Premium, ItemType.ColdDrink),
    Menu("White Wine", 5.00, ItemQuality.Premium, ItemType.ColdDrink)
  )

  val MenuList: Seq[MenuItem] = Seq(coffee, greenTea,)

  def getMenuItems: List[Menu] = standardItems ++ premiumItems


  case class MenuItem(
                       name: String,
                       price: Double,
                       isHot: Boolean = false,
                       isFood: Boolean = false,
                       isPremium: Boolean = false
                     )

  def displayMenu(MenuItem: List[MenuItem]): Unit = {
    MenuItem.foreach { menuItem =>
      println(
        s"""
           Name: ${MenuItem.name}, Price: ${MenuItem.price}
    """.stripMargin
      )
    }
    println(s"$MenuItem.length")


    def removeMenuItem(item: MenuItem): Either[MenuErrorMessage, Menu] = {
      item.itemType match {
      case Right (ItemType.HotDrinks) => copy(hotDrinks = hotDrinks.filterNot(_ == item))
      case Right (ItemType.HotDrinks) => copy(coldDrinks = coldDrinks.filterNot(_ == item))
      case Right (ItemType.HotDrinks) => copy(hotDrinks = HotFoods.filterNot(_ == item))
      case Right (ItemType.HotDrinks) => copy(coldFoods = HotFoods.filterNot(_ == item))
      case _ => Left (MenuErrorMessage.InputInvalid)
    }
    }

  }

  sealed class MenuErrorMessage

  object MenuError {
    case object SomethingWentWrongError extends MenuErrorMessage("Something strange went wrong!")
    case object InputInvalid extends MenuErrorMessage("You input was invalid")
  }
}


/** POS SYSTEM - Service Charge Option[20%] - val menuTotal
 * Cold drinks only - no service charge - else 0 charge
 * Hot drinks or cold Food - 10% (2 decimals) - val hasHotDrinkOrColdFood
 * Hot foods - 20% with max s.charge of £20 - val hasHotFood
 * Premium - 25% with a max s.charge of £40 - val hasPremiumItem
 * Custom service charge Option - Additional or instead of current
 *
 * POS SYSTEM  - Loyalty Scheme (create Customer case class - params of below)
 * Either Drinks Loyalty or Discount Loyalty (create DrinksLoyalty & DiscountLoyalty case class)
 * Customer Requirements - They must not have a card, must have purchases > 5, over 18 (create boolean if statement to match requirements)
 * */

val menuTotal = order.items.map(_.price).sum
val hasHotDrinkOrColdFood = order.items.exists(item => item.isHot || (item.isFood && !item.isHot))
val hasHotFood = order.items.exists(item => item.isFood && item.isHot)
val hasPremiumItem = order.items.exists(_.isPremium)



case class Customer(
                   name: String,
                   age: Int,
                   ordersTotal: Int, // orders.length
                   drinksLoyalty: Option[DrinksLoyaltyCard] = None,
                   discountLoyalty: Option[DiscountLoyaltyCard] = None
                    )

case class DrinksLoyaltyCard()

case class DiscountLoyaltyCard()

"calculateServiceCharge" should {
  "calculate service charge at 25%" when {
    "order contains only one premium item" in {
      val newOrder: Order = Order(List(yogurtParfait, pancakes), tom)
      calculateServiceCharge(newOrder) shouldEqual 2.375
    }
    "order contains multiple premium items" in {
      val newOrder: Order = Order(List(yogurtParfait, pancakes, eggsBenedict, lemonade), tom)
      calculateServiceCharge(newOrder) shouldEqual 5.125
    }
  }
  "calculate service charge at 25% and cap at 40" in {
    val newOrder: Order = Order(List(smashBurger), tom)
    calculateServiceCharge(newOrder) shouldEqual 40.0
  }
  "calculate service charge at 20%" when {
    "order contains only one hot food item, but no premium" in {
      val newOrder: Order = Order(List(pancakes), tom)
      calculateServiceCharge(newOrder) shouldEqual 1.0
    }
    "order contains multiple items including hot food, but no premium" in {
      val newOrder: Order = Order(List(pancakes, greenTea), tom)
      calculateServiceCharge(newOrder) shouldEqual 1.5
    }
  }
  "calculate service charge at 20% and cap at 20" in {
    val newOrder: Order = Order(List(chickenBurger), tom)
    calculateServiceCharge(newOrder) shouldEqual 20.0
  }
  "calculate service charge at 10%" when {
    "order contains hot drinks" in {
      val newOrder: Order = Order(List(greenTea), tom)
      calculateServiceCharge(newOrder) shouldEqual 0.25
    }
    "order contains cold food" in {
      val newOrder: Order = Order(List(caesarSalad), tom)
      calculateServiceCharge(newOrder) shouldEqual 0.6
    }
    "order contains cold food and hot drinks" in {
      val newOrder: Order = Order(List(caesarSalad, greenTea), tom)
      calculateServiceCharge(newOrder) shouldEqual 0.85
    }
  }
  "calculate no service charge" when {
    "order contains only cold drinks and no premium items" in {
      val newOrder: Order = Order(List(icedCoffee), tom)
      calculateServiceCharge(newOrder) shouldEqual 0.0
    }
  }
}

def displayMenu(MenuItem: List[MenuItem]): Unit = {
  MenuItem.foreach { menuItem =>
    println(
      s"""
           | Name: ${MenuItem.name}, Price: ${MenuItem.price}
           | Total:
    """.stripMargin
    )
  }
  println(s"$MenuItem.length")

def calculateBill(order: Order, customServiceCharge: Option[CustomServiceCharge]): Bill = {
  val menuTotal = order.items.map(_.price).sum
  val serviceCharge = BigDecimal(totalServiceCharge).setScale(2, RoundingMode.HALF_UP).toDouble
  val bill = menuTotal + serviceCharge
} bill
}