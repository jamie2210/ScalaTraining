import java.security.KeyStore.TrustedCertificateEntry
// MVP

//import scala.util.Random
//
//val waterMelons: Int = Random.nextInt (11)

val waterMelons: Int = 4

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


val johnHasBag :Boolean = true

if ((johnHasBag && waterMelons <= 5) ||
   (!johnHasBag && waterMelons <= 3)) {
  println(s"John wants $waterMelons melons so can carry his melons")
} else {
  println("John wants more melons than he can carry")
}

println(f"Total Cost = £${waterMelons*1.397}%.2f")



