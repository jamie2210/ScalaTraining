package Week2.monday.sanctuary

class Dog (
  val name: String,
  val age: Float,
  val furColour: String,
  val hasTail: Boolean
  ) extends Mammal with Domesticated with Species {
    val dietType: DietType = Carnivore
    val personality: Personality = Friendly
    val conservationStatus: String = "Least Concern"
    val domestic: Boolean = true
    val makesLoyalPet: Boolean = true
    val speciesName: String = "Flat Coat Retriever"
    val averageLifSpan: (Int, Int) = (10,15)
}
