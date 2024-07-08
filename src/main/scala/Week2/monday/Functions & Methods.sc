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

// Define a function named `printSeq` that takes an integer `n` as a parameter and returns nothing (Unit)
def printSeq(n: Int): Unit = {
  // Create a range from 0 to n-1
  val index = 0 until n
  // Iterate over the range and print each Fibonacci number
  index.foreach(i => println(fibonacci(i)))
}

// Call the `printSeq` function with the argument 5 to print the first 5 Fibonacci numbers
printSeq(5)
