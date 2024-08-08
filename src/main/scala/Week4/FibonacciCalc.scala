package Week4

import scala.annotation.tailrec

object FibonacciCalc extends App {
// recursive fibonacci
  def fibonacciCalc1(n: Int): Int = {
    if (n <= 0) {
      0
    } else if (n <= 2) {
      1
    } else fibonacciCalc1(n - 1) + fibonacciCalc1(n - 2)
  }

  println("\n fib test")
  println(fibonacciCalc1(6))

 //tail recursive fibonacci

  def fibonacciCalc2(x: Int): Either[String, Int] = {
    if (x < 0) Left("Number must not be a negative")
    else {
      @tailrec
      def fibHelper(n: Int, a: Int, b: Int): Int = n match {
        case 0 => a
        case 1 => b
        case _ => fibHelper(n - 1, b, a + b)
      }
      Right(fibHelper(x, 0, 1))
    }
  }

  println(fibonacciCalc2(10)) // Should print Right(55)
  println(fibonacciCalc2(-1)) // Should print Left("Number must not be a negative")


}

