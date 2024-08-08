package Week4

import Week4.Recursion.Fruit.{Apple, Banana, Fruit, Grape, Orange, Peach}

import scala.annotation.tailrec

object Recursion extends App{

  // standard Recursion

  def factorial (n: Int) : Int = {
    if (n <= 1) {
      1
    } else {
//      println(s"Currently working on ${n-1}")
      val finalResult = n * (factorial(n-1))
      // println(s"I'm the final call of  $n")
      n * factorial(n-1)
      finalResult
    }
  }
  println("\nFactorial method (4) - standard rec:")
  println(factorial(4))
//  println(factorial(400000)) - stack overflow error - limited memory on the call stack

  // Tail Recursion
  // Helps stop the stack overflow error - reuses the call stack instead of adding to it all the time

  def factorialTailRec(n: Int) : Long = {
    @tailrec // happy it is tail recursive
    def factorialHelper(x: Int, acc: Int) : Long = { // helper method - has an accumulator + any additional params that may be needed during the recursion but not in the original method
      if (x <= 1) acc
      else {
//        println(s"current x: $x")
//        println(s"Current acc: $acc")
        factorialHelper(x-1, x * acc) // - holds the running total - storing that intermediate
      }
    }
    factorialHelper(n, 1)
  }
  println(s"\n Factorial Tail Rec of 4")
  println(factorialTailRec(4))

  // 1st call: factorialHelper (4-1, 4 * 1) = (3, 4)
  // 2nd call: factorialHelper (3-1, 3 * 4) = (2, 12)
  // 3rd call: factorialHelper (2-1, 2 * 12) = (1, 24)
  // 4th call: x == 1 => hitting the 'if' and returning the acc which is currently stored at 24
  println(factorialTailRec(11))

  // tail rec -> concatenate a string n times
  // Without a helper method
  @tailrec
  def concatenateWords(aWord: String, n: Int, acc: String): String = {
    if (n <= 0) acc
    else {
      concatenateWords(aWord, n-1, aWord + acc)
    }
  }
  println(s"\n tail rec concatenateWords")
  println(concatenateWords("hello, ", 3, "World"))

  def numOfElements(list: List[String]): Int = {
    if (list.isEmpty) 0
    else 1 + numOfElements(list.tail)
  }
  println("\n num of elements " + numOfElements(List("a", "b", "c", "d")))

  // Tail rec version
  @tailrec
  def numbOfElementsTailRec(list: List[String], acc: Int): Int = {
    if (list.isEmpty) acc
    else numbOfElementsTailRec(list.tail, acc + 1)
  }
  println("\n num of elements tail rec " + numbOfElementsTailRec(List("a", "b", "c"), 0))

  // standard recursion with match cases
  def numOfElementsMatch(list: List[String]): Int = list match {
    case Nil => 0
    case ::(head, tail) =>
      println(s"current head: $head")
      println(s"Current tail: $tail")
      1 + numOfElementsMatch(tail)
  }
  println("\n num of elements match: " + numOfElementsMatch(List("a", "b", "c")))

  // match for tail rec
  def numOfElementsMatchTailRec(list: List[String], acc: Int): Int = list match {
    case Nil => acc
    case ::(head, tail) => numOfElementsMatchTailRec(tail, acc + 1)
  }
  println("\n match on tail rec: " + numOfElementsMatchTailRec(List("a", "b", "c"), 0))

  /** Recursion with Enums */

  object DayOfWeek extends Enumeration {
    type DayOfWeek = Value // this allows DayOfWeek to be used as a type
    val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
  }

  def enumListToString(dayOfWeekEnums: List[DayOfWeek.Value]): String = {
    def enumListHelper(dayEnums: List[DayOfWeek.Value], acc: String): String = {
      dayEnums match {
        case Nil => acc
        case ::(head, tail) =>
          val makeNiceToRead = if (acc.isEmpty) "" else ", "
          enumListHelper(tail, acc + makeNiceToRead + head.toString)
      }
    }
    enumListHelper(dayOfWeekEnums, "")
  }
  println(s"\n enum to string method: " + enumListToString(List(DayOfWeek.Monday, DayOfWeek.Tuesday, DayOfWeek.Wednesday, DayOfWeek.Thursday)))

  /** Recursion with case objects */

  sealed trait DayWeek

    object Monday extends DayWeek
    object Tuesday extends DayWeek
    object Wednesday extends DayWeek
    object Thursday extends DayWeek
    object Friday extends DayWeek
    object Saturday extends DayWeek
    object Sunday extends DayWeek

  def objectsToString(listDays: List[DayWeek]): String = {
    def helperMethod(remainingListDays: List[DayWeek], acc: String): String = {
      remainingListDays match {
        case Nil => acc
        case ::(head, tail) =>
          val makeNiceToRead = if (acc.isEmpty) "" else ", "
         helperMethod(tail, acc + makeNiceToRead + head.toString)
      }
    }
    helperMethod(listDays, "")
  }
  println(s"\n object to string: " + objectsToString(List(Monday, Tuesday, Wednesday)))

  object Fruit extends Enumeration {
    type Fruit = Value
    val Apple, Banana, Orange, Grape, Peach = Value
  }

  def countFruit(fruits:List[Fruit], targetFruit: Fruit): Int = {
    def helperFruit(remainingFruitList: List[Fruit], acc: Int): Int = {
      remainingFruitList match {
        case Nil => acc
        case ::(head, tail) =>
          val updatingAcc = if (head == targetFruit) acc + 1 else acc //add to count only if present
        helperFruit(tail, updatingAcc)
      }
    }
    helperFruit(fruits, 0)
  }
  val fruitList = List(Apple, Orange, Banana, Grape, Peach, Banana, Banana)
  val targetFruit = Banana
  println(" \n Fruit count: " + countFruit(fruitList, targetFruit))
}
