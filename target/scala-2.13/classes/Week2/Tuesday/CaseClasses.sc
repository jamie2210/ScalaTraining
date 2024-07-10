/** CASE CLASSES */

// Extra methods
// - an apply method
// unapply method
// hashcode and equals method
// copy method
// toString method

case class SuperHero(realName: String, heroName: String, weakness: String)
// apply method
// ue to make objects
val newSuperHero: SuperHero = SuperHero.apply(realName = "Bruce Wayne", heroName = "Batman", weakness = "No super power")
// OR write it out
// don't need to use the keyword 'new'
val anotherNewSuperHero: SuperHero = SuperHero(realName = "Clark Kent", heroName = "Superman", weakness = "Kryptonite")

// ==
newSuperHero == anotherNewSuperHero
// will compare what makes the up the object (params) not the name of the object

// Copy method
val updateName = anotherNewSuperHero.copy(realName = "Clark Lane")

anotherNewSuperHero

/** CASE OBJECTS */

case object Hulk
case object Superman
