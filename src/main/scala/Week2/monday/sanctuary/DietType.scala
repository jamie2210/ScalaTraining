package Week2.monday.sanctuary

sealed trait DietType {
  val eats: String
}

object Omnivore extends DietType {
  val eats: String = "Plants and meat"
}

object Carnivore extends DietType {
  val eats: String = "Meat"
}

object Herbivore extends DietType {
  val eats: String = "Plants"
}