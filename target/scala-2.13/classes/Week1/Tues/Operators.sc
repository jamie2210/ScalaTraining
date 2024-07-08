// Arithmetic
/**
 * + (a+b)
 * - (a-b)
 * / (a/b)
 * * (a*b)
 * % modulus (a%b) - finds the remainder
 */

val a:Int = 10
val b:Int = 5
val c:Int = 3

val add = a + b
val subtract = a - b
val divide = a / b
val multiply = a * b
val modulus = a % c

// Relational Operators

// Compare 2 booleans

/**
 * == (equality)
 * != (Inequality)
 * < (less than)
 * <= (less than or equal to)
 * > (greater than)
 * >= (great than or equal to)
 */

val equality = a == b
val inequality = a != b
val lessThan = a < b
val lessThanOrEqual = a <= b
val greatThan = a > b
val greatThanOrEqual = a >= b

//Logical
// Com bine boolean

/**
 * AND(&&)
 * OR (||)
 * NOT (!)
 */

val and: Boolean = true && false // both must be true to return true
val or: Boolean = true || false // one can be true to return true
val not: Boolean = !true

val a:Boolean = false
val b:Boolean = false

val answer:Boolean = !a

val a:Boolean = (4+3)*55 < 300
val b:Boolean = 96/12 >= 8
val c:Boolean = "hamster" < "hippo"
val d:Boolean = 8%2 == 0
val e:Boolean = 156/8 < 20 && 54 < 20 && 54 / 4 < 14

val ansA:Boolean = 3 + 4 * 57 < 300
val ansB:Boolean = 144/12 >= 12
val ansC:Boolean = "Cat" < "Dog"
val ansD:Boolean = "Rabbit" < "Hamster"
val ansE:Boolean = 17%2 != 0
val ansF:Boolean = 75/9 < 30 && 89/6 < 20

val string:String = "This is a string" // a variable that stores a sting

println(string)
println("This is a string")

/**
 * A string is something you can put words in giving the val/var content
 * println is a function that will print what ever is in it.
 * Both the val and println contain the same string so are one in the same.
 * But the val will produce no output unless called by a println function
 * println returns a unit, it is not specific
  */

// Extension 1
val extOne:Boolean = "STRING" == "string" // False as not exact

// Extension 2
val extTwo = "one"

val number = extTwo match {
  case "one" => 1
}

println(number)

// Extension 3
val extThree = 1

val word = extThree match {
  case 1 => "one"
}

println(word)

// Extension 4
val extFour = 1

extFour.toString

println(extFour, extFour.toString)

// Extension 5
val estFive:String = "string"

estFive.toUpperCase

// Extension 6
val estSix:String = "first word should be capitalized".capitalize

// Research
//val new:String = "test"

/** Does not work as new is reserved as a key keyword in Skala so
 * a different name must be used. As per below;
 */

// val `new`

val newString:String = "test"

// a list of keywords - https://www.geeksforgeeks.org/scala-keywords/