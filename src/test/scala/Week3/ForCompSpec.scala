package Week3

import Week3.Thursday.ForComp._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class ForCompSpec extends AnyWordSpec with Matchers {

  "retrieveNumber" should {
    val expected = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    "generate a sequence of numbers from 1-10" in {
      retrieveNumbers shouldBe expected
    }

    "start with 1 end with 10" in {
      retrieveNumbers.head shouldBe 1
      retrieveNumbers.last shouldBe 10
    }
  }
}
