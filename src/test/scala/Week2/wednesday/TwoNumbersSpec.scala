package Week2.wednesday

import org.scalatest.FlatSpec

class TwoNumbersSpec extends FlatSpec {

  "add" should "add numbers" in {
    val numbers1 = new TwoNumbers(1, 2) // new instance of the class
    assert(numbers1.add == 3)
  }

  "subtractYFromX" should "subtract y from x" in {
    val numbers2 = new TwoNumbers(1, 2)
    assert(numbers2.subtractYFromX == -1)
  }

  "multiply" should "multiply" in {
    val numbers3 = new TwoNumbers(1,2)
    assert(numbers3.multiply == 2)
  }

  "divideXByY" should "divide x by y" in {
    val numbers4 = new TwoNumbers(1,2)
    assert(numbers4.divideXByY == 0.5)
  }

  "isAMultiple" should "Find if is divisible" in {
    val numbers5 = new TwoNumbers(2,1)
    assert(numbers5.isAMultiple())
  }
  "isAMultiple" should "Find if is NOT divisible" in {
    val numbers6 = new TwoNumbers(1,2)
    assert(!numbers6.isAMultiple)
  }
}
