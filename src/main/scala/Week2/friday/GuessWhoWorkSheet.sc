/** $$$ GUESS WHO GAME WORKSHEET $$$ */

//object GuessWho {
//  ???
//}

case abstract class Character{
  val isMale: Boolean
}

/** ----------------------------------- Character List */

class CharacterList(val characterNames: List[String])

val fullCharacterList = new CharacterList(List("Alice", "Bob", "John", "Mary", "Peter"))

/** --------------------------------Person Class */

case abstract class Person extends Character with HasHair with Eyes {
  val name: String
  val gender: String
  val age: Int
  val eyeColour: String
  val isBald: Boolean
  val hasHair: HasHair = Blonde
  val eyes: Eyes = Blue
}

/** ------------------------------ Hair Trait */

sealed trait HasHair {
  val hairColour: String
}

object Blonde extends HasHair {
  val hairColour: String = "Blonde"
}

object Brunette extends HasHair {
  val hairColour: String = "Brunette"
}

object Black extends HasHair {
  val hairColour: String = "Black"
}

object RedHead extends HasHair {
  val hairColour: String = "Redhead"
}

/** ------------------------------ Eyes Trait */

sealed trait Eyes {
  val eyeColour: String
}

object Blue extends Eyes {
  val eyeColour: String = "Blue"
}

object Green extends Eyes {
  val eyeColour: String = "Green"
}

object Brown extends Eyes {
  val eyeColour: String = "Brown"
}


/** ----------------------------- Person NAme Trait */

sealed trait Name {
  val eyeColour: String
  val name: String
  val age: Int
  val gender: String
}

object Mary extends Name {
  val eyeColour: String = "Blue"
  val name: String = "Mary"
  val age: Int = 45
  val gender: String = "Female"
}