package Week2.monday.sanctuary

class Lizard (
  val name: String,
  val age: Float,
  val colourOfSkin: String,
  val rowsOfTeeth: Int
) extends Reptile with Species with Domesticated {
  val dietType: DietType = Omnivore
  val conservationStatus: String = "Endangered"
  val domestic: Boolean = false
  val makesLoyalPet: Boolean = false
  val speciesName: String = "Komodo Dragon"
  val averageLifSpan: (Int, Int) = (95,105)
}
