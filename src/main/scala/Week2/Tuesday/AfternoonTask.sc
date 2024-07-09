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

// 2. Which of the following lines of code is runnable and which will produce an error

// a)
case class Person(name: String, age: Int, nationality: String, isStudent: Boolean)
// b)
val firstPerson = new Person("Carlos", 23, "Spanish", true) // error (new)
// c)
val secondPerson = Person("Carlos", 23, "Spanish", true)
// d)
val thirdPerson = Person("Chloe", 25, "British", false)
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
val oneMoreChocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
val finalChocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")

chocolateMuffin == blueberryMuffin
chocolateMuffin == vanillaMuffin
blueberryMuffin == vanillaMuffin

chocolateMuffin == anotherChocolateMuffin
chocolateMuffin == oneMoreChocolateMuffin
chocolateMuffin == finalChocolateMuffin
// only true when contents/values are the same

val isEqual = List(anotherChocolateMuffin, oneMoreChocolateMuffin, finalChocolateMuffin) == chocolateMuffin // false

val isEqual2 = List(anotherChocolateMuffin, oneMoreChocolateMuffin, finalChocolateMuffin).contains(chocolateMuffin) // true


