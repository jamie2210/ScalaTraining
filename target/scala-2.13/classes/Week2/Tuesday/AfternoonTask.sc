/** Differences of Case & Class
1. Default Methods:

Class: Does not automatically provide methods like equals, hashCode, and toString.
Case Class: Automatically provides implementations for equals, hashCode, and toString.

2. Pattern Matching:

Class: Cannot be used directly in pattern matching.
Case Class: Instances can be decomposed using pattern matching.

3. Immutability:

Class: Instances can be mutable or immutable depending on the definition.
Case Class: Instances are immutable by default. All fields are val unless explicitly declared as var.

*/

/** MVP */

// 2. Which of the following lines of code is runnable and which will produce an error

// a)
case class Person(name: String, age: Int, nationality: String, isStudent: Boolean)
// b)
val firstPerson = new Person("Carlos", 23, "Spanish", true) // error (new)
// c)
val secondPerson = Person("Carlos", 23, "Spanish", isStudent = true)
// d)
//thirdPerson = Person("Chloe", 25, "British", isStudent = false) // error - no val
// e)
class Animal(name: String, colour: String, pet: Boolean)
// f)
//val cat = Animal("cat", "black", true) // error (requires new)
// g)
val dog = new Animal("dog", "white", true)

// 3. After reviewing all combinations, which are true when compared using the "==" operator?

case class Muffin(flavour: String, price: Double, storeBoughtFrom: String)
val chocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
val blueberryMuffin = Muffin("blueberry", 3.5, "Mercator Bakery")
val vanillaMuffin = Muffin("vanilla", 3.50, "Mercator Bakery")

val anotherChocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
val oneMoreChocolateMuffin = Muffin("Chocolate", 3.50, "Mercator Bakery")
val finalChocolateMuffin = Muffin("choocolate", 2.50, "MercatorBakery")

chocolateMuffin == blueberryMuffin
chocolateMuffin == vanillaMuffin
blueberryMuffin == vanillaMuffin

chocolateMuffin == anotherChocolateMuffin
chocolateMuffin == oneMoreChocolateMuffin
chocolateMuffin == finalChocolateMuffin
// only true when contents/values are the same

val isEqual = List(anotherChocolateMuffin, oneMoreChocolateMuffin, finalChocolateMuffin) == chocolateMuffin // false

val isEqual2 = List(anotherChocolateMuffin, oneMoreChocolateMuffin, finalChocolateMuffin).contains(chocolateMuffin) // true

/** EXTENSION */

case class Fruit (name: String, tropical: Boolean, cost: Double)
case object FruitStore

//case object FruitStore extends Fruit (name = "Strawberry", tropical = false, cost = 2.5)

val fruit1 = Fruit(name = "Banana", tropical = true, cost = 0.90)
val fruit2 = Fruit(name = "Apple", tropical = false, cost = 1.20)
val fruit3 = Fruit(name = "Mango", tropical = true, cost = 3.95)

val fruit1Name = fruit1.copy(name = "Coconut")
val fruit2Tropical = fruit2.copy(name = "Pineapple", tropical = true)
val fruit3Cost = fruit3.copy(cost = 2.79)

fruit1Name.toString
fruit2Tropical.toString
fruit3Cost.toString
fruit3Cost


fruit1Name
fruit2Tropical
fruit3Cost

fruit1.equals(fruit2)
