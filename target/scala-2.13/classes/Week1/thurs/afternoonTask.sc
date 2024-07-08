/** MVP */

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
// returns true if seq contains the word orange

/** 2. ----------------------------------------------- */

val numIsOdd :List[Boolean] = numList.map {
  num => num %2 !=0
}
// returns true for all odd numbers and false for all even in the list

val numIsOdd :List[Boolean] = numList.map {_ %2 !=0}
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

/** EXTENSION */

/** 1. ----------------------------------------------- */

val numberSeq: Seq[Int] = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9)

val uniqueNum: Seq[Int] = numberSeq.filter {
  num => (num < 3) || ((num > 4 && num < 8) && num %2 !=0)
}

/**
 * filter first finds numbers less than 3
 * then next finds the range that is more than 4 and less than 8
 * and then calls for the odd numbers within that range
 */

/** 2. ----------------------------------------------- */

val numList: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

val listHead: Int = numList.head
val listTail: List[Int] = numList.tail
val listTail2: List[Int] = listTail.tail
// keep removing the head to get required number
val head3: Int = listTail2.head

/** RESEARCH */

/** 1. ----------------------------------------------- */
// Sets
// The Set is an iterable collection with no duplicate elements.
/**
 * On a Set, one doesn't control the ordering of elements, so you simply add elements to it.
 * On a Seq, because each element has an index,
 * it is relevant where the element is being placed,
 * and so we have +: and :+, which specify, respectively,
 * that an element is to be prepended or appended to the sequence.
 */
Set(1,2) == Set(2,1,1,1)
Set(2,1,1,1,1)
Seq(2,1) == Seq(1,2)

/** 2. ----------------------------------------------- */
List(3,4) == Seq(3,4)
// true because a list is sequence
List(5,6) == Set(5,6)
// false because a set is different to a sequence
Set(5,6) == Set(6,5)
// True as order is not registered in a set
