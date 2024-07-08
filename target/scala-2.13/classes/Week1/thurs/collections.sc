//Seq
val seq1: Seq[Int] = Seq(1, 2, 3)

//List
val list1: List[Int] = List(1, 2, 3)

// Maps
// Key Value Pairs : key -> value

val map1: Map[String, Int] = Map(
  "One" -> 1,
  "Two" -> 2,
  "Three" -> 3
)

val getSeqData: Int = seq1(1)
val getSeqHead: Int = seq1.head
val getSeqTail: Seq[Int] = seq1.tail
// Tail gives everything but first element (in index position 0)

val getListData: Int = list1(2)
val getListHead: Int = list1.head
val getListTail: List[Int] = list1.tail

val GetMapData = map1("One")
val GetMapData3 = map1("Three")

val tripledSeq: Seq[Int] = seq1.map {
  number => number * 3
}

val tripledList: List[Int] = list1.map {
  list => list * 3
}

val tripledMap: Map[String, Int] = map1.map {
  case (key, value) => (key, value * 3)
}

val changeKey: Map[String, Int] = map1.map {
  case (key, value) => (key + "s", value)
}

val changeKeyAndValue: Map[String, Int] = map1.map {
  case (key, value) => (key + "s", value * 4)
}

// Filter
val filteredSeq: Seq[Int] = seq1.filter {
  number => number > 1
}
val filteredList: List[Int] = list1.filter {
  number => number > 1
}

filteredSeq == filteredList

val filteredMap: Map[String, Int] = {
  map1.filter(number => number._2 > 1)
}

val filteredMap2: Map[String, Int] = {
  map1.filter(number => number._1 != "One")
}

// Map[String, Int] - This is a tuple

val filterNotList: List[Int] = {
  list1.filterNot(number => number >= 2)
}
//logical! - similar

// Exists
// Boolean

val listExists: Boolean = list1.exists{
  number => number > 6
}

val seqExists: Boolean = seq1.exists{
  number => number > 6
}

val mapExists: Boolean = map1.exists {
  number => number._1 == "four"
}

// Contains
// checks for one parameter

val containsSeq: Boolean = seq1.contains(4) || seq1.contains(2)
val containsList: Boolean = list1.contains(2)
val containsMap: Boolean = map1.contains("Two")


// Sets
// The Set is an iterable collection with no duplicate elements.

//flatmap

val nameSequence: Seq[String] = Seq("mercator", "group")
nameSequence.flatMap(_.toUpperCase())

// Arrays
val array1: Array[Int] = Array(1, 2, 3)
val plusTwo: Array[Int] = array1.map {
  _ + 2
}
