/** ------------------------------------- Dogs */
case class Dog (name: String, breed: String, age: Int)

val dog1: Dog = Dog (name = "Bob", breed = "Jack Russell", age = 4)
val dog2: Dog = Dog (name = "Fred", breed = "Labrador", age = 6)
val dog3: Dog = Dog (name = "Sarah", breed = "Golden Retriever", age = 2)
val dog4: Dog = Dog (name = "Gill", breed = "Schnauzer", age = 5)

val allDogs = List(dog1, dog2, dog3, dog4)

/** ------------------------------------- Cats */
case class Cat (name: String, breed: String, age: Int)
val cat1: Cat = Cat (name = "Kitty", breed = "Tiger", age = 3)
val cat2: Cat = Cat (name = "Action", breed = "Bengal", age = 1)

val allCats = List(cat1, cat2)

/** ------------------------------------- Birds */
case class Bird (name: String, breed: String, age: Int)
val bird1: Bird = Bird (name = "Big Bird", breed = "Canary", age = 45)

val allBirds = List(bird1)

/** ------------------------------------- Kennels */
// Define a case class Kennel with fields name, dogs, cats, and birds.
case class Kennel(name: String, dogs:List[Dog], cats:List[Cat], birds:List[Bird]) {
  // Method to add multiple dogs to the kennel.
  def addDogs(newDogs: List[Dog]): Kennel = {
    // Create a new Kennel instance by making a copy of the current instance (`this`).
    // Update the `dogs` field of the new instance:
    this.copy(dogs = newDogs ++ this.dogs)
    // Concatenate (`++`) the newDogs list with the existing list of dogs (`this.dogs`).
  }

  // Method to add a new cat to the kennel.
  def addCat(newCat: Cat): Kennel = {
    // Create a new Kennel instance by making a copy of the current instance (`this`).
    // Update the `cats` field of the new instance:
    this.copy(cats = newCat :: this.cats)
    // Prepend (`::`) the newCat to the existing list of cats (`this.cats`).

  }
  def addBird(newBird: Bird): Kennel = {
    this.copy(birds = newBird :: this.birds)
  }
}

val newKennel: Kennel = Kennel("The Dog House", allDogs, allCats, allBirds)

val newDogs = List(
  Dog("Roger", "Great Dane", 6),
  Dog("Bryan", "Dalmatian", 2)
)
val newCat: Cat = Cat("Paws", "Maine Coon",11)
val newBird: Bird = Bird("Terry", "Bue Tit", 1)

val updateKennel = newKennel
  .addDogs(newDogs)
  .addCat(newCat)
  .addBird(newBird)

val kennelNameChange = updateKennel.copy(name = "Pet Palace")