val academyNames: Seq[String] = Seq(
  "Jamie", "Antony", "Arei", "Bilal", "Joe", "Muhammad",
  "Roshan", "Spencer", "Tayamui", "Tom",
)

val colourNumbers: Map[Int, String] = Map (
  1 -> "red", 2 -> "yellow", 3 -> "blue", 4 -> "green", 4 -> "green"
)
colourNumbers(3)

val numbersPlus1: Map[Int, String] = colourNumbers.map {
  case (key, value) => (key + 1, value)
}

val filterOdd: Map[Int, String] = {
  colourNumbers.filter(number => number._1%2 !=0)
}

val namesContainR: Boolean = academyNames.exists(_.toLowerCase.contains("r"))

//Sets and extraction Keys or Values

val stringSet: Set[String] = colourNumbers.values.toSet
val intSet: Set[Int] = colourNumbers.keys.toSet

val addPhrase: Seq[String] = academyNames.flatMap (s =>
  if(s.toLowerCase() == "jamie") Seq(s.toUpperCase() + " The Ledge")
  else Seq(s)
)

var x = Seq[Int](3)
x :+= 1
x :+= 2
print(x)

val y = Seq(3, 4, 5)
// 6 -> Seq(3,4,5,6)
val z = y ++ Seq(6, 7, 8)
print(z)


