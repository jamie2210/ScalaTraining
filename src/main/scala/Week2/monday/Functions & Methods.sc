/** FUNCTIONS & METHODS */

/**
 * FUNCTIONS
 * assigned to a val
 * also Methods
 * no different to any other type
 *  don't have to name them (however if we don't, they aren't reusable
 */

/**
 * keyword 'def'
 * belong to a class
 * can be overridden
 * must be named
 */

// Anonymous function
(number: Int) => number + 1

// Name Function
val addition = (number: Int) => number + 1

// Method (also a function)
def addition: Int => Int = (number: Int) => number + 1

// Override Method
def addition: Int => Int = (number: Int) => number + 10

// Write a cup of tea

def makeACupOfTea(numberOfSugars:Int): String = {
  true
  346564
  val cuppa = "tea"
  s"You have a tea with ${numberOfSugars} spoons of sugar."
}
// calling the method
makeACupOfTea(4)

// VAT method

val vat: Double = 1.2
// callable as within the same scope
def priceWithVat(price:Double): Double = {
  price * vat
}
priceWithVat(30)

// Methods within a class
class Number(num: Int) {
   def addition(aDifferentNum: Int): Int = {
     num + aDifferentNum
   }
}
val newNumberClass = new Number(4)
val classAddition = newNumberClass.addition(7)

// Task 1
def getBigVal(input1: Int, input2: Int): String = {
  if (input1 > input2) {
    "First"
  } else if (input1 < input2) {
    "Second"
  } else {
    "Same"
  }
}

getBigVal(10, 7)

def nameLength (firstName: String, secondName: String): Int = {
  if (firstName.length > secondName.length) {
    firstName.length
  } else if (secondName.length > firstName.length) {
    secondName.length
  } else if (firstName.length == secondName.length) {
    0
  } else {
    404
  }
}

nameLength("James", "Robby")

/** Pure and Impure Functions */
// PURE
val sentence: String =" "
def append(sentence:String, word:String): String = {
  sentence + " " + word.trim()
}
val a = append(sentence, "Yo!") // Yo!
val b = append(sentence, "Yo!") // Yo!

// Impure
var sentence2: String = " "
def append(word:String): String = {
  sentence2 = sentence2 + " " + word
  sentence2.trim
}

val a = append("Yo!") // Yo!
val b = append("Yo!") // Yo! Yo!

// METHODS SHOULD BE PURE

/** PURE FUNCTION TASK */

/** ----------------------------------- Arei */

//Fibonacci Sequence
// Define a function named `fibonacci` that takes an integer `i` as a parameter and returns an integer
def fibonacci(i: Int): Int = {
  // Initialize the first two values of the custom Fibonacci sequence
  val f1 = 3
  val f2 = 4

  // Base case: if `i` is 0, return the first value of the sequence
  if (i == 0)
    f1
  // Base case: if `i` is 1, return the second value of the sequence
  else if (i == 1)
    f2
  // Recursive case: if `i` is greater than 1, calculate the Fibonacci value recursively
  else {
    // Compute the (i-1)th Fibonacci number
    val fPrev1 = fibonacci(i - 1)
    // Compute the (i-2)th Fibonacci number
    val fPrev2 = fibonacci(i - 2)
    // Return the sum of the two previous Fibonacci numbers
    fPrev1 + fPrev2
  }
}
fibonacci(10)

/** f1 & f2 */
// 0   1   2   3   4   5   6   7   8   9   10
/** Fib seq from 3,4 */
// 3   4   7   11  18  29  47  76  123 199 322


/** ----------------------------------- Tom */

// Define a recursive function to compute the Fibonacci sequence

// Pure fibonacci function
def fibonacciPure(n: Int, seq: Seq[Int]): Seq[Int] = {

  // Retrieve the last element of the sequence, which is the most recent Fibonacci number
  val n1: Int = seq.reverse.head

  // Retrieve the second-to-last element of the sequence
  val n2: Int = seq.reverse.tail.head

  // Base case: if n is less than or equal to 0, return the current sequence
  if (n <= 0) seq

  // Recursive case: otherwise, append the sum of the last two elements to the sequence
  // and call fibonacciPure with n decremented by 1
  else fibonacciPure(n - 1, seq :+ (n1 + n2))
}

// Example usage
val start = Seq(3, 4) // The starting sequence for Fibonacci, typically starting with 0 and 1
fibonacciPure(10, start) // Compute the first 5 additional Fibonacci numbers starting from the initial sequence


// Impure fibonacci function
// Define a mutable variable to hold the sequence of Fibonacci numbers
var sequence: Seq[Int] = Seq(3, 4)

// Define an impure recursive function to compute the Fibonacci sequence
def fibonacciImpure(n: Int): Seq[Int] = {

  // Retrieve the last element of the sequence, which is the most recent Fibonacci number
  val n1: Int = sequence.reverse.head

  // Retrieve the second-to-last element of the sequence
  val n2: Int = sequence.reverse.tail.head

  // Base case: if n is less than or equal to 0, return the current sequence
  if (n <= 0) sequence

  // Recursive case: otherwise, append the sum of the last two elements to the sequence,
  // update the mutable sequence variable, and call fibonacciImpure with n decremented by 1
  else {
    sequence = sequence :+ (n1 + n2)
    fibonacciImpure(n - 1)
  }
}

// Example usage
fibonacciImpure(5) // Compute the first 5 additional Fibonacci numbers starting from the initial sequence

