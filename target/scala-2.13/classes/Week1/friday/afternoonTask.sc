/** AFTERNOON TASK */

/** ----------------------------- Animal Class */

// Unimplemented members so any animal can be input
class Animal (
  val name: String,
  val age: Int
)

/** ----------------------------- Specific Type Class */

class Mammal extends Animal (
  val hasFourLegs: Boolean,
  val seaDweller: Boolean,
  val hasTail: Boolean,
  val skinOrFurColour: String,
  val uniqueFeature: String,
  val animalType: String = "Mammal"
)

abstract class Reptile extends Animal {
              val hasLegs: Boolean
              val colourOfSkin: String
              val rowsOfTeeth: Int
              val uniqueFeature: String
              val animalType: String = "Reptile"
              }

abstract class Bird extends Animal {
              val wingSpan: Int
              val canFly: Boolean
              val featherColour: String
              val uniqueFeature: String
              val animalType: String = "Bird"
              }

abstract class Fish extends Animal{
           val seaOrFreshWater: String
           val length: Int
           val colourOfScales: String
           val highInOmega3: Boolean
           val uniqueFeature: String
           val animalType: String = "Fish"
            }

/** ----------------------------- Specific Feature Traits */

trait ExtraInfo {
  val speciesName: String
  val topSpeed: Int
  val creatureOfThe: String
}

/** ----------------------------- Create Dog class */

//val Dog: Animal = new Animal (
//  name = "Barny", age = 5
//)

class Dog extends Mammal with ExtraInfo {
  name = "Barny"
  age = 5
  hasFourLegs = true
  hasTail = true
  seaDweller = false
  skinOrFurColour = "Black"
  uniqueFeature = "Very playful"
  override val creatureOfThe: String = "Day"
  override val topSpeed: Int = 35
  override val speciesName: String = "Schnauzer"
}

// Create an instance of Dog
val barny: Dog = new Dog

// Print the properties of the Dog instance
println(s"Dog animal type is a ${barny.animalType}")
println(s"Dog's name: ${barny.name}")
println(s"Dog's age: ${barny.age}")
println(s"Has four legs: ${barny.hasFourLegs}")
println(s"Sea dweller: ${barny.seaDweller}")
println(s"Has tail: ${barny.hasTail}")
println(s"Skin or fur colour: ${barny.skinOrFurColour}")
println(s"Unique feature: ${barny.uniqueFeature}")
println(s"Creature of the: ${barny.creatureOfThe}")
println(s"Top speed: ${barny.topSpeed}mph")
println(s"Species name: ${barny.speciesName}")

/** ----------------------------- Create Snake class */

//val Snake: Animal = new Animal (
//  name = "Trevor", age = 35
//)

class Snake extends Reptile (
  name = "Trevor",
  age = 23,
  hasLegs = false,
  colourOfSkin = "Green",
  rowsOfTeeth = 7,
  uniqueFeature = "Can climb trees"
) with ExtraInfo {
  override val creatureOfThe: String = "Day & Night"
  override val topSpeed: Int = 28
  override val speciesName: String = "Green Mamba"
}

// Create instance of snake

val trevor: Snake = new Snake

// Print the properties of the Snake instance
println(s"Snake animal type is a ${trevor.animalType}")
println(s"Snake's name: ${trevor.name}")
println(s"Snake's age: ${trevor.age}")
println(s"Has legs: ${trevor.hasLegs}")
println(s"Colour of skin: ${trevor.colourOfSkin}")
println(s"Row's of teeth: ${trevor.rowsOfTeeth}")
println(s"Unique feature: ${trevor.uniqueFeature}")
println(s"Creature of the: ${trevor.creatureOfThe}")
println(s"Top speed: ${trevor.topSpeed}mph")
println(s"Species name: ${trevor.speciesName}")

/** ----------------------------- Create a sealed trait */

sealed trait Dietary