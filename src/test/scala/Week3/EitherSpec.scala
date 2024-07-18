package Week3

import Week3.Thursday.Either._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class EitherSpec extends AnyWordSpec with Matchers {

  "isOdd should" {
    "return a Right" when {
      "number is odd" in {
        val result = isOdd(3)
        result shouldBe Right("3 is odd")
      }
      "the number is odd and large" in {
        val result = isOdd((10001))
        result shouldBe Right("10001 is odd")
      }
    }
    "Return a left" when {
      "number is even" in {
//        val result = isOdd(4)
//        result shouldBe Left(IsOddError)
        isOdd(4) shouldBe Left(IsOddError)
      }
    }
  }

}
