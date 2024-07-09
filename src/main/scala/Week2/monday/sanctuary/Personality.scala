package Week2.monday.sanctuary

sealed trait Personality {
   val demeanor: String
}

object Friendly extends Personality {
  val demeanor: String = "friendly and fun, loves attention"
}

object Aggressive extends Personality {
  val demeanor: String = "will attack if provoked"
}

object Assertive extends Personality {
  val demeanor: String = "outgoing and confident"
}
