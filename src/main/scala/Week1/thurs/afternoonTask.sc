/** 1. ----------------------------------------------- a) */

val numList: List[Int] = List(1, 2, 3, 4, 5)
// List of numbers 1-5

val primeSeq: Seq[String] = Seq("Red", "Yellow", "Blue")
// Sequence of primary colours

/** ----------------------------------------------- b) */

val tripNumList: List[Int] = numList.map {
  num => num * 3
}
// using map to times each number in list by 3

val tripShortHand: List[Int] = numList.map {_ * 3}
// short hand version

/** ----------------------------------------------- c) */

val removeBlue: Seq[String] = primeSeq.filter  {
  colour => colour != "Blue"
}
// Filter anything other than "Blue"
val removeBlue: Seq[String] = primeSeq.filter {_ != "Blue"}
// Short hand version

/** ----------------------------------------------- d) */

val isOrange :Boolean = primeSeq.exists(_.toLowerCase.contains("orange"))

/** 2. ----------------------------------------------- */

val numIsOdd :Boolean = numList.exists {
  num => num %2 !=0
}
// returns true if odd, false if even, true if both in list

val numIsOdd :Boolean = numList.exists {_ %2 !=0}
// Short hand version

/** 3. ----------------------------------------------- */

val petsOfDave: Map[String, List[String]] = Map(
  "Dog" -> List("Shabba", "Skibba", "Trigga"),
  "Cat" -> List ("Prince"),
  "T-Rex" -> List ("King"),
  "Lama" -> List ("Food")
)

/** 4. ----------------------------------------------- */

val dogsOfDave: Map[String, List[String]] = {
  petsOfDave.filter(dog => dog._1 == "Dog")
}
// Did not create a list

val dogsOfDave: List[String] = {
  petsOfDave.getOrElse("Dog", List.empty)
}
// creates list and an empty one of "Dog" not present

val dogsOfDave: List[String] = petsOfDave.get("Dog") match {
  case Some(dogs) => dogs
  case None => List.empty
}
// Same outcome different method
