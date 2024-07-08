val weather: String = "cold"
//val season: String = "winter"

//if(weather == "cold" || season == "winter") {
//  println(s"It is $weather" + "! take a coat.")
//} else {
//  print(s"Don't take a coat")
//}

if (weather == "cold") {
  println("Take a coat")
} else if (weather == "rain") {
  println("Take an umbrella")
} else {
  print("Take nothing")
}

// Task 1

val result: Int = 76

if (result >= 90) {
  println("A")
} else if (result >= 80) {
  println("B")
} else if (result >= 70) {
  println("C")
} else if (result >= 60) {
  println("D")
} else if (result >= 50) {
  println("E")
} else if (result < 50) {
  println("F")
}