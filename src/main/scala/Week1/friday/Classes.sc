/** CLASSES */
// Capitol for the name
// Delcare using 'class'
// act as blueprint

// First way - unimplemented members
class ThemeParkEmptyParams (val hasRollerCoasters: Boolean, val diameterOfLargestLoop: Double)

// Second way - implement
// {} braces used here
// default params
class ThemeParkDefaultParams {
  val hasRollerCoasters: Boolean = true
  val diameterOfLargestLoop: Double = 76.443
}

// Everything inside the {} belongs to that class. Members of the class.

class ThemeParkBoth (val diameterOfLargestLoop: Double) {
  val hasRollerCoasters: Boolean = true
}

// Use classes to make objects
/** STATE BEHAVIOUR IDENTITY */
// A person

// State: Sex, gender, ethnicity, hair colour etc
// Behaviour: Eat, drink. sleep, work, exercise
// Identity: Name

/** OBJECTS */
// Keyword - new
// Capitalized

val mercatorPark: ThemeParkEmptyParams = new ThemeParkEmptyParams(
  hasRollerCoasters = true, diameterOfLargestLoop = 99.45
)
mercatorPark.getClass
mercatorPark.diameterOfLargestLoop

//Default params
val disneyWorld: ThemeParkDefaultParams = new ThemeParkDefaultParams()
disneyWorld.diameterOfLargestLoop

/** PARAMETERS */
// Give meaningful name
// raw values or existing vals can be passed in

class Hamster (age: Int, val colour: String)
val orange: String = "Orange"
// make Hamster object
val booTheHamster: Hamster = new Hamster(age = 1, colour = orange)

/** Objects without classes */
// When we only have 1 of something
// Don't use the 'new' keyword
// No parameters
// Available globally


object DavidsDogs {
  val Loki: String = "Loki"
  val Tai: String = "Tai"
  val Isla: String = "Isla"
  val Buster: String = "Buster"
  val Oscar: String = "Oscar"
}

DavidsDogs.Isla

/** INHERITANCE */
// use the 'extends' keyword
// declare class we want to extend
// class we extend is called the 'parent' or 'superclass'
// extends inherits everything in the class

//class Bakken extends ThemeParkDefaultParams {
//  override val diameterOfLargestLoop: Double = 44.32
//  val oldestThePark: Boolean = true
//}

class Bakken extends ThemeParkEmptyParams (hasRollerCoasters = true, diameterOfLargestLoop = 201.5) {
  override val diameterOfLargestLoop: Double = 44.32
  val oldestThePark: Boolean = true
}

// Family tree example
class ParentSurname {val surname: String = "Main Surname"}

class DirectChild extends ParentSurname {

}

/** Family tree task */

class Person (firstName: String) {
  val surname: String = "Smith"
}

class Dad extends Person ("Steve")

class girlFriend extends Person ("Jess") {
  override val surname: String = "Jones"
}

/** TRAITS */
// keyword - 'with'
// Can extend multiple traits
// traits can have unimplemented members
// we cannot create and instance of trait (like we can a class)
// use in combination with something else

trait Mascot {
  val nameOfMainCharacter: String
}

trait OverSizedFood {
  val hasTurkeyLeg: Boolean
}

class DisneyWorld extends ThemeParkDefaultParams with Mascot with OverSizedFood {
  override val nameOfMainCharacter: String = "Mickey Mouse"
  override val diameterOfLargestLoop: Double = 546.77
  override val hasTurkeyLeg: Boolean = true
}
