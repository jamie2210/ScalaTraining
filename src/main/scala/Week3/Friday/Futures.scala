package Week3.Friday

// for futures - global = lazy vals
import Week3.Friday.Futures.{addition, additionEitherInAFuture, waitTime}
import Week3.Thursday.Either.{IsOddError, NewError}

import java.util.concurrent.TimeUnit
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.{Duration, FiniteDuration}
import scala.util.Success

object Futures extends App {



  // act as a place holder

  def addition (x: Int, y: Int): Int = {
    Thread.sleep(1000) // long computation
    x + y
  }

  def additionInAFuture: Future[Int] = Future {
    addition(1,2)
  }

  val waitTime: FiniteDuration = Duration(10, TimeUnit.SECONDS)
  println(Await.result(additionInAFuture, waitTime))


  /** Either Option */

  val startTime = System.currentTimeMillis()

  def additionEither (x: Int, y: Int): Either[String, Int] = {
    Thread.sleep(1000)
    if (startTime > 1000) Left("You took too long!") else
    Right(x + y)
  }

  def additionEitherInAFuture: Future[Int] = Future {
    addition(1,2)
  }

  val waitTimeEither: FiniteDuration = Duration(10, TimeUnit.SECONDS)
  println(Await.result(additionEitherInAFuture, waitTime))


/** IsOdd Futures Extension */

  def isOdd(x: Int): Either[NewError, String] =
    if (x%2 != 0) Right(s"$x is odd") else Left(IsOddError)

//  println(isOdd(4)) // expecting error
//  println(isOdd(9)) // expecting Right

  /** Try/Catch */

  def plusOne(x: String): Either[String, Int] = {
    try {
      Right{x.toInt}
    } catch {
      case e: Exception => Left(s"Failed due to $e") // wildcard
    }
  }

  def fetchisOddOrError(x: Int): Future[Either[NewError, String]] =
    Future {
    Thread.sleep(1000)
    isOdd(x)
  }

  def eventualIsOddOrError: Future[Either[NewError, String]] = {
    fetchisOddOrError(5)
  }

  def matchIsOddError: String = eventualIsOddOrError.value match {
    case Some(Success(complete)) => s"Future complete: $complete"
    case None => "Future did not complete in the given time"
  }
  println(Await.ready(eventualIsOddOrError, waitTime))
}

