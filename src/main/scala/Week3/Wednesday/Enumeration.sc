// finite set of data

/** NATIVE */

object Weekday extends Enumeration {
  val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
}

Weekday.Monday.toString

// useful for acronyms/long names
object BetterWeekDay extends Enumeration {
  val Monday = Value("Mon")
  val Tuesday = Value("Tues")
  val Wednesday = Value("Weds")
  val Thursday = Value("Thur")
  val Friday = Value("Fri")
  val Saturday = Value("Sat")
  val Sunday = Value("Sun")
}

BetterWeekDay.Saturday

BetterWeekDay.values
BetterWeekDay.Monday < BetterWeekDay.Sunday // ordered by index position

object ReOrderWeekDay extends Enumeration {
  val Monday = Value(1, "Mon")
  val Tuesday = Value(2)
  val Wednesday = Value(0, "weds (First)")
  val Thursday = Value(4)
  val Friday = Value(5)
  val Saturday = Value(10, "Sat (last)")
  val Sunday = Value(7)
}

ReOrderWeekDay.values

def exhaustiveMatch(weekDay: BetterWeekDay.Value): String = {
  weekDay match {
    case BetterWeekDay.Monday => "Mon"
    case BetterWeekDay.Tuesday => "Tues"
    case BetterWeekDay.Wednesday => "Weds"
    case BetterWeekDay.Thursday => "Thurs"
    case BetterWeekDay.Friday => "Fri"
    case BetterWeekDay.Saturday => "Sat"
    case BetterWeekDay.Sunday => "Sun"
  }
}

// be careful
def nonExhaustiveMatch(weekDay: BetterWeekDay.Value): String = {
  weekDay match {
    case BetterWeekDay.Monday => "Mon"
    case BetterWeekDay.Sunday => "Sun"
  }
}

/** Sealed case objects */

sealed trait Weekday

case object Monday extends Weekday
case object Tuesday extends Weekday
case object Wednesday extends Weekday
case object Thursday extends Weekday
case object Friday extends Weekday
case object Saturday extends Weekday
case object Sunday extends Weekday

def caseObjectMatch(weekday1: Weekday): String = {
  weekday1 match {
    case Monday => "mon"
    case Tuesday => "tues"
    case Wednesday => "weds"
    case Thursday => "thurs"
    case Friday => "fri"
    case Saturday => "sat"
    case Sunday => "sun"
  }
}

// must be exhaustive - will compilation warning if not
// no easy way to access all values - would need to map
// no default ordering

abstract class Error (name: String, errorCode: Int)
case object WeekdayNotFound extends Error("Weekday not found", 404)


//object FootballClubs extends Enumeration {
//  val Chelsea, Spurs, Arsenal = Value
//}

//FootballClubs.Chelsea.toString

object LondonFootballClubs extends Enumeration {
  val chelsea = Value("Blue")
  val Spurs = Value("White")
  val Arsenal = Value("Red")
}

LondonFootballClubs.chelsea

sealed trait FootballClubs

case object Chelsea extends FootballClubs
case object Spurs extends FootballClubs
case object Arsenal extends FootballClubs

def footballClubs(footballClubsColour: FootballClubs): String = {
  footballClubsColour match {
    case Chelsea => "blue"
    case Spurs => "white"
    case Arsenal => "red"
  }
}
