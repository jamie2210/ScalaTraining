package Week3.Thursday

object ForComp extends App {

  // <- this is a call

  /** Classic */

  def retrieveNumbers: Seq[Int] = {
    for (numbers <- 1 to 10) yield numbers
    // for 1 to 10 print the numbers
  }
  println(retrieveNumbers)
  def squareNumbers: Seq[Int]= for (numbers <- 1 to 10) yield numbers * numbers
  println(squareNumbers)
  def ifGuardNumbers: Seq[Int]= for (numbers <- 1 to 10 if numbers % 2 == 0) yield numbers
  println(ifGuardNumbers)

  /** use with case classes */
  sealed trait Colour
  case object Blue extends Colour
  case object Green extends Colour
  case object Yellow extends Colour

  case class Pencil(colour: Colour, sharpened: Boolean)

  def getPencils: List[Pencil] = for {
    colour <- List(Blue, Green, Yellow)
    sharpened <- List(true, false)
  } yield Pencil(colour, sharpened)

println(getPencils)

  def getTruePencils: List[Pencil] = for {
    colour <- List(Blue, Green, Yellow)
    sharpened <- List(true)
  } yield Pencil(colour, sharpened)

  println(getTruePencils)

  val namesList = List("jamie", "mark", "bob")

  def capitaliseNames(names: List[String]): List[String] = {
    for (name <- names) yield name.toUpperCase
  }

  val capitals = capitaliseNames(namesList)
  println(capitals)

  def capitaliseFirst(names: List[String]): List[String] = {
    for (name <- names) yield name.capitalize
  }

  val capitalsFirst = capitaliseFirst(namesList)
  println(capitalsFirst)

  def task1(nameInput: List[String]): List[String] = {
    for {
      name <- nameInput.map(x => x.toUpperCase)
    } yield name
  }

  println(task1(List("bob", "jay")))
}





