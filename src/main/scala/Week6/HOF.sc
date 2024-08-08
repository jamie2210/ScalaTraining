/** High Order Functions */

// what does it mean to be a first class citizen?
// We can:

// 1. assign functions to vals:
val addition: (Int, Int) => Int = (x,y) => x + y
addition(1,2)

val subtract: (Int, Int) => Int = (x,y) => x - y
subtract(1,2)

//2. Store functions in collections (e.g. lists, maps, seq)
val functionList = List(
  (a:Int, b:Int) => a + b,
  (a:Int, b:Int) => a * b,
  (a:Int, b:Int) => a - b,
  (a:Int, b:Int) => a / b
)

functionList.head(1,2)
functionList(1)(2,2)
functionList(2)(6,2)
functionList(3)(9,3)

// 3. pass functions into arguments/params
def manipulateNumbers(x:Int, y:Int, function:(Int, Int) => Int): Int = {
  function(x,y)
}

manipulateNumbers(1,2, addition)
manipulateNumbers(6,2, subtract)

// 4. return functions from other functions
def createAdditionFunction (x: Int): Int => Int = {
//  println(s"$x")
  (y:Int) => x + y
}
createAdditionFunction(1)
val addOne: Int => Int = createAdditionFunction(2)
addOne(4)

/** Function as params */
def firstHOF(x: Int, function: Int => Int): Int = {
  function(x)
}
def addTwo(n: Int): Int = n + 2
firstHOF(3, addTwo)

def square(n: Int): Int = n * n
firstHOF(3, square)

def processTheList(list1: List[String], function: String => String): List[String] = {
  list1.map(function)
}
def addS(word: String): String = word + "s"
def upperCase(word: String): String = word.toUpperCase()
val newList: List[String] = List("apple", "banana", "pear", "mango")

processTheList(newList, addS)
processTheList(newList, upperCase)

// map - common HOF
val numbers = Seq(1,2,3,4,5)
val doubledNumbers = numbers.map(num => num*2)
val tripledNumbers = numbers.map(_*3)

//foldLeft - used to reduce a collection into a single value.
val foldLeftExample = numbers.foldLeft(0)(_ + _) // (_ + _) - (acc + current value)

val stringList = List("we", "love", "scala")
val concatenatedString = stringList.foldLeft("")(_ + " " + _).trim

// foldRight
val foldLeftExample = numbers.foldRight(0)(_ + _) // (_ + _) - (acc + current value)

val concatenatedStringRight = stringList.foldRight("")(_ + " " + _).trim

case class Male (male:Boolean)
case class Animal(name: String, male: Male)
val animalList = List(Animal("Fred the fox", Male(true)), Animal("Sally the Seahorse", Male(false)), Animal("Lucky the lion", Male(true)))

val foldAnimalIsLeft = animalList.foldLeft(List[String]()) { (acc, animal) =>
  val sirOrMadame = animal.male match {
    case Male(true) => "Sir"
    case Male(false) => "Madame"
  }
  acc :+ s"$sirOrMadame ${animal.name}"
}

println(foldAnimalIsLeft)

val foldAnimalIsRight = animalList.foldRight(List[String]()) { (animal, acc) =>
  val sirOrMadame = animal.male match {
    case Male(true) => "Sir"
    case Male(false) => "Madame"
  }
  acc :+ s"$sirOrMadame ${animal.name}"
}

println(foldAnimalIsRight)

val numbersProduct = numbers.foldLeft(1)(_ * _)
val trueInts = numbers.filter(n => n % 2 == 0)

val countCharacters = stringList.foldLeft("")(_ + " " + _).length
val capitalizeCharacters = stringList.foldLeft("")(_ + " " + _).capitalize.trim

val Cont = stringList.foldLeft(""){ (acc, value) =>
  acc + " " + value.capitalize.trim
}

/** Returning functions */
def smallRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.1
}
def mediumRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.2
}
def largeRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.5
}

case class Employee(name: String, salary: Double, lengthOfEmployment: Int)

def getPayRise (employee: Employee): (Int, Double) => Double = {
  employee.lengthOfEmployment match {
    case year if year <= 3 => smallRise(employee.salary)
    case year if year <= 5 => mediumRise(employee.salary)
    case year if year > 5 => largeRise(employee.salary)
  }
}

val Amanda = Employee("Amanda", 30000.00, 2)
val choosePayRise = getPayRise(Amanda)
val getNewSalary = choosePayRise(Amanda.lengthOfEmployment, Amanda.salary)


// closing down store task
def lowDiscount(price: Double): Double => Double = {
  (price: Double) => price * 0.8
}
def midDiscount(price: Double): Double => Double = {
  (price: Double) => price * 0.6
}
def highDiscount(price: Double): Double => Double = {
  (price: Double) => price * 0.5
}

case class Item(price: Double)

def getDiscount (item: Item): Double => Double = {
  item.price match {
    case amount if amount < 20 => lowDiscount(item.price)
    case amount if amount >= 20 && amount < 50 => midDiscount(item.price)
    case amount if amount > 50 => highDiscount(item.price)
  }
}

val hawaiianShirt = Item(32.99)
val selectDiscount = getDiscount(hawaiianShirt)
val discountItem = selectDiscount(hawaiianShirt.price)