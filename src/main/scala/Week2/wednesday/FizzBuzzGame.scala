package Week2.wednesday

  class FizzBuzzGame {

    def fizzBuzz(x: Int): String = {
      if (x % 3 == 0 && x % 5 == 0) {
        "FizzBuzz"
      } else if (x % 5 == 0) {
        "Buzz"
      } else if (x % 3 == 0)  {
        "Fizz"
      } else {
        "Oops, somethings wrong"
      }
    }
  }

object Main extends App {
  val StringAns = new FizzBuzzGame
  println(StringAns.fizzBuzz(30))
  println(StringAns.fizzBuzz(9))
  println(StringAns.fizzBuzz(10))
  println(StringAns.fizzBuzz(17))
}
