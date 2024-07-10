package Week2.wednesday

class TwoNumbers (x: Int, y: Int){

  def add(): Int = {
    x + y
  }

  def subtractYFromX() : Int = {
    x - y
  }

  def multiply(): Int = {
    x * y
  }

  def divideXByY(): Double = {
    x.toDouble / y.toDouble
  }

  // %
  def isAMultiple(): Boolean = {
    x % y == 0
  }

}
