/** With parentheses () */

// Classes are the blueprint, Objects inherit the blueprint and allow manipulation

// construct with no defined parameters
class Park1
// Make object
new Park1

// Construct wth defined parameters
// We are not giving default values
// We do not have to put val or var (best practice to include)
class Park2 (val rollerCoater: Boolean, val largestLoop: Double)
// Make object
new Park2(true, 45.67)
new Park2(rollerCoater = false, largestLoop = 0.00)
// Extend Park2 Class - must event values because there are no default
object Disney extends Park2 (rollerCoater = true, largestLoop = 17.25)

// Abstract Class - if we are not giving default values but are defined params
// By making it abstract - safety net, forces specific and needed params
abstract class Park3(val coaster: Boolean, val loop: Double)
// Make object
new Park3 // Can't make object of abstract classes
// Must be extended by something

// Constructing with default params
// Unlikely to change
class Park4(val coaster: Boolean = true, val loop: Double = 44.56)
// Make object
new Park4 // Can make due to default values
// do not need to use keyword override or val/var
// If not overriding do not include
new Park4 (coaster = false) // Loop left as default but coaster is overridden

/** With curly braces {} */
class Park5 {}
// Make object
new Park5

// Constructed with defined params but not default - CAN'T DO
class Park6 {
  val coaster: Boolean
  val loop: Double
}
// Must either be abstract OR give defaults

abstract class Park7 {
  val coaster: Boolean
  val loop: Double
}

// Construct with default params
// Must have a new line
// Must include val/var
class Park8 {
  val coaster: Boolean = true
  val loop: Double = 44.56
}
// Make object
new Park8 // Use of default params
// Can override
val p = new Park8 {
  override val coaster: Boolean = false
  override val loop: Double = 0.00
}
// Can override some, none OR all
p.coaster
p.loop
// We can extend
object LegoLand extends Park8
LegoLand.coaster
// Override (some, none OR all)
object LegoLand2 extends Park8 {
  override val loop: Double = 777.88
}

/** ABSTRACT CLASSES */
// Making a blueprint that isn't going to change
/** {} */
// Must use val/var
abstract class Park9 {
  val coaster: Boolean
  val loop: Double
}
// make object
new Park9 {
  val coaster: Boolean = true
  val loop: Double = 55.21
}
// every param in abstract class must have values
// When extending - must give value to every param (even if it has a default)
object HydePark extends Park9 {
  override val coaster: Boolean = false
  override val loop: Double = 0.00
}

/** () */
abstract class Park10(val coaster: Boolean, val loop: Double)
// Make object
new Park10(true, 44.4) // - NOPE!
// Can't do. Can not make an object from an abstract class with parentheses

// Extend the class we can make an object
object EuropaWorld extends Park10(coaster = true, loop = 23.45)

// What is accessible?
EuropaWorld.coaster
// Will loose access to params if you remove val/var from the abstract class with ()

/** () and {} */
class Park11 (val coaster: Boolean) {
  val loop: Double = 7.6
}
// If using both () no default needed, using {} must have default value
new Park11 (coaster = true)

abstract class Park12 (val coaster: Boolean) {
  val loop: Double = 7.6
}
// If abstract must override values within the {}
new Park12 (coaster = true) {
  override val loop: Double = 33.23
}

/** Traits */
// Without defaults
trait CandyFloss {
  val hasCandyFloss: Boolean
}
// Defined value but not a default
object EuropaWorld2 extends CandyFloss {
  override val hasCandyFloss: Boolean = true
}

trait CandyFloss1 {
  val hasCandyFloss1: Boolean = true
}
object AnotherNewPark3 extends CandyFloss1 // Can still override as above

/** SEALED KEYWORDS */
// Can only access in the same file
sealed abstract class SealedAbstractClass
sealed trait SealedTrait
// allows for exhaustive matching (to be continued....)