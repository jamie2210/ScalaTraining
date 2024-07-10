package Week2.wednesday

import org.scalatest.FlatSpec

class NameLengthSpec extends FlatSpec {

  "getNameLength" should "return first name if length is > than surname length" in {
    val returnFirstName = new NameLength()
    assert(returnFirstName.getNameLength("Jonathan", "Smith" ) == "Jonathan".length)
  }

  "getNameLength" should "return surname if length is > than first name" in {
    val returnSurname = new NameLength()
    assert(returnSurname.getNameLength("Jay", "Skibba") == "Skibba".length)
  }

  "getNameLength" should "return 0 if first name and surname are the same" in {
    val returnZero = new NameLength()
    assert(returnZero.getNameLength("Jamie", "Letts") == 0)
  }
}