package Week2.monday.sanctuary

trait Species {
  val speciesName: String
  val conservationStatus: String
  val averageLifSpan: (Int, Int)
  val dietType: DietType
}
