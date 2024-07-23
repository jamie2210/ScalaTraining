package Week4

import Week4.AfternoonTask.Teams.{England, France, Germany}

import scala.annotation.tailrec

// Task One.

object AfternoonTask extends App {

    object EurosTeams extends Enumeration {
      type teams = Value
      val England, Spain, France, Germany, Italy, Portugal = Value
    }


    def teamsToString(eurosTeams: List[EurosTeams.Value]): String = {
      @tailrec
        def teamsHelper(eurosTeams: List[EurosTeams.Value], acc: String): String = {
          eurosTeams match {
            case Nil => acc
            case ::(head, tail) =>
              val tidyList = if (acc.isEmpty) "" else ", "
              teamsHelper(tail, acc + tidyList + head.toString)
          }
        }
      teamsHelper(eurosTeams, "")
    }
  val teamList = EurosTeams.values.toList
  print(s"\n euros teams as Strings: " + teamsToString(teamList))


  // Task Two
  sealed class Teams(val name: String)

  object Teams {
    case object England extends Teams("England")
    case object Spain extends Teams("Spain")
    case object France extends Teams("France")
    case object Germany extends Teams("Germany")
    case object Italy extends Teams("Italy")
    case object Portugal extends Teams("Portugal")
  }

  def teamsObject(newTeams: List[Teams]): String = {
    @tailrec
    def teamsObjectHelper(newTeamsList: List[Teams], acc: String): String = {
      newTeamsList match {
        case Nil => acc
        case head :: tail =>
          val stringTidy = if (acc.isEmpty) "" else ", "
          teamsObjectHelper(tail, acc + stringTidy + head)
      }
    }
    teamsObjectHelper(newTeams, "")
  }
  println(s"\n Euros teams from case objects: " + teamsObject(List(Teams.France, Teams.England, Teams.Germany)))


  // Task Three

  val numbers: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

  def isEven(x: Int): Either[String, Boolean] = {
    @tailrec
    def isEvenHelper(currentList: List[Int], acc: Int): Either[String, Boolean] = {
      currentList match {
        case Nil => Left("Index must be between 1 and 19")
        case head :: _ if acc == x => Right(head%2 == 0)
        case _ :: tail => isEvenHelper(tail, acc+1)
      }
    }
    isEvenHelper(numbers, 0)
  }
  println(s"\n IsEven Test results:")
  println(isEven(11))
  println(isEven(4))
  println(isEven(20))



  // Task Four
  def additonalRec(x: Int): Int = {
    @tailrec
    def additionalRecHelper(x: Int, acc: Int): Int = {
      if (x <= 1) acc
      else {
        additionalRecHelper(x-1, x + acc)
      }
    }
    additionalRecHelper(x, 1)
  }
  println("s\n additionalRec Test Results:")
  println(additonalRec(5))
  println(additonalRec(20))
  println(additonalRec(2))

}






