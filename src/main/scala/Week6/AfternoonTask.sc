/* Task 1a */

val multiply: Int => Int = x => x*5
multiply(5)

def applyTwice(y: Int, multiply: Int => Int): Int = {
  multiply(multiply(y))
}

applyTwice(2, multiply)

/* Task 1b */
def addition(x: Double, y: Double): Double = {
  x + y
}
def subtraction(x: Double, y: Double): Double = {
  x - y
}
def multiplication(x: Double, y: Double): Double = {
  x * y
}
def division(x: Double, y: Double): Double = {
  x / y
}

def mathFunc(n1: Double, n2: Double, function:(Double, Double) => Double): Double = {
  function(n1, n2)
}

mathFunc(4,5, addition)
mathFunc(4,5, subtraction)
mathFunc(4,5, multiplication)
mathFunc(4,5, division)

/* Task 2a */
val convertToUpperCase: String => String = x => x.toUpperCase()
convertToUpperCase("I'm a test")

val convertToLowerCase: String => String = x => x.toLowerCase()
convertToLowerCase("I'M ALSO A TEST")

def convertString(makeStringUpperCase: Boolean): String => String = {
  if(makeStringUpperCase) convertToUpperCase else convertToLowerCase
}

val testString = "cOnVeRtMe"
convertString(true)(testString)
convertString(false)(testString)

/* Task 2b */

def calculate(x: String): (Double, Double) => Double = {
  x.toLowerCase() match {
    case "add" => addition
    case "subtract" => subtraction
    case "multiply" => multiplication
    case "divide" => division
  }
}

val calculateAdd = calculate("add")
val addResult = calculateAdd(16, 5)

val calculateDivide = calculate("divide")
val divideResult = calculateDivide(353, 32)
println(s"$addResult is an addition where $divideResult came from a division")

/* Extension */

// Task 1

def max(x: Double, y: Double): Double = {
  math.max(x, y)
}

val largeNumber = max(3, 9)
println(largeNumber)

def maxListNum(num: List[Double], max:(Double, Double) => Double): Double = {
  num.reduce(max)
}

val numbers = List(3.5, 7.2, 1.8, 9.4, 2.6)
val maxNumber = maxListNum(numbers, max)
println(maxNumber)

// Task 2
def applyFunc(function: Int => Int, x: Int): Int = {
  function(x)
}

def double(n: Int): Int = n*2
def squared(n: Int): Int = n*n

val result1 = applyFunc(double, 5)
val result2 = applyFunc(squared, 5)
println(result1, result2)

// Task 3
def power(exponent: Int): Int => Int = {
  base => Math.pow(base, exponent).toInt
}

val square: Int => Int = power(2)

println(square(6))  // Output: 36


