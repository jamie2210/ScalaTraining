package Week2.monday.sanctuary

class Eagle (
  val name: String,
  val age: Float,
  val birdOfPrey: Boolean,
  val featherColour: String
) extends Bird with Species with Domesticated with Fly {
  val dietType: DietType = Carnivore
  val conservationStatus: String = "Least Concern"
  val domestic: Boolean = false
  val makesLoyalPet: Boolean = false
  val speciesName: String = "Golden Eagle"
  val averageLifSpan: (Int, Int) = (45,55)
  val canFly: Boolean = true
  val wingSpan: (Double, Double) = (1.8, 2.3)
}
