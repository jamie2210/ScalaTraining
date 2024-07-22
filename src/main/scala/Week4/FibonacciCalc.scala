package Week4

object FibonacciCalc extends App {

//  def fibonacciCalc(x: Int): Either[String, Int] = {
//    if (x < 0) Left("Number must not be a negative")
//      else {
//        def fibHelper(x: Int, acc: Int): Int = {
//      }
//    }
//  }

  def fibonacciCalc(x: Int): Either[String, Int] = {
    if (x < 0) Left("Number must not be a negative")
    else {
      def fibHelper(n: Int, a: Int, b: Int): Int = n match {
        case 0 => a
        case 1 => b
        case _ => fibHelper(n - 1, b, a + b)
      }
      Right(fibHelper(x, 0, 1))
    }
  }

  println(fibonacciCalc(10)) // Should print Right(55)
  println(fibonacciCalc(-1)) // Should print Left("Number must not be a negative")


}

