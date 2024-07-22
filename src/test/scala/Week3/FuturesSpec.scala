package Week3

import Week3.Friday.Futures.{addition, additionInAFuture}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Millis, Seconds, Span}

class FuturesSpec extends AnyWordSpec with Matchers with ScalaFutures {

  implicit val defaultWaitTime: PatienceConfig = PatienceConfig(timeout = Span(3, Seconds), interval = Span(500, Millis))

  "addition method" should {
    "add two ints" in {
      addition(1,2) shouldEqual 3
    }
  }
  //unit test the future
  "additionInTheFuture" should {
    "eventually return sum" in {
      whenReady(additionInAFuture) {
        result => result shouldEqual 3
      }
    }
  }
}
