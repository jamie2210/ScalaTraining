import java.security.KeyStore.TrustedCertificateEntry
// MVP

//import scala.util.Random
//
//val waterMelons: Int = Random.nextInt (11)

val waterMelons: Int = 7
// number of melons
if (waterMelons == 0) {
  println (s"John wants $waterMelons melons, so goes home.")
} else if (waterMelons > 0 && waterMelons <= 3) {
  println (s"John wants $waterMelons Melons so doesn't need a bag.")
} else if (waterMelons > 3 && waterMelons < 6) {
  println (s"John wants $waterMelons Melons so needs a bag.")
} else if (waterMelons > 5) {
  println (s"John wants $waterMelons Melons so can't carry them.")
} else {
  println (s"An error has occurred, $waterMelons is not valid.")
}

/**
 * if else statement determine whether john can
 * based on number of melons
 */

val johnHasBag :Boolean = true

if ((johnHasBag && waterMelons <= 5) ||
   (!johnHasBag && waterMelons <= 3))
  // 2 options for if John is carrying 5 or less or 3 or less melons
{
  println(s"John wants $waterMelons melons so can carry his melons")
} else {
  println(s"John wants $waterMelons melons which is more than he can carry")
}
// outcome on whether john can carry melons or not
println(f"Total Cost = £${waterMelons*1.397}%.2f")
// works out total dependant on number of melons

// Extension

val booleanTest :Boolean = (true || false && false)

println(booleanTest)

val booleanTestTwo :Boolean = ((true || false) && false)

println(booleanTestTwo)

val booleanTestThree :Boolean = ((1 < 4 && 7 != 10) || 9 + 10 == 21)

println(booleanTestThree)

// Research

val number1 :Int = 40
val number2 :Int = 30
var myString :String = ""
// create an empty string

if (number1 > number2) {
  myString = "Yes"
} else {
  myString = "No"
}

println(myString)
/**
 * if else statement ask which of the 2 numbers is higher adding yes
 * or no to the string var
 */

val number1 :Int = 40
val number2 :Int = 30
var newString :String = if (number1 > number2) "yes" else "no"
println(newString)
