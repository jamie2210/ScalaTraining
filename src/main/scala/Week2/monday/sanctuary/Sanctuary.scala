package Week2.monday.sanctuary

object Sanctuary extends App {

  def feedAnimal(animal: Animal) = println(s"You fed ${animal.name} some tasty ${animal.dietType.eats}!")

    val mollyTheDog = new Dog ("Molly", 7, "Black", true)
    val peterTheKomodo = new Lizard ("Peter", 68, "Dark Green", 17)
    val sallyTheEagle = new Eagle ("Sally", 33, true, "Brown")

    feedAnimal(mollyTheDog)
    feedAnimal(peterTheKomodo)
    feedAnimal(sallyTheEagle)

}



