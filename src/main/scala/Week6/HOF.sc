/** High Order Functions */

// what does it mean to be a first class citizen?
// We can:

// 1. assign functions to vals:
val addition: (Int, Int) => Int = (x,y) => x + y
addition(1,2)

val subtract: (Int, Int) => Int = (x,y) => x + y
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
manipulateNumbers(1,2, subtract)

// 4. return functions from other functions
def createAdditionFunction (x: Int): Int => Int = {
//  println(s"$x")
  (y:Int) => x + y
}
createAdditionFunction(1)
val addOne: Int => Int = createAdditionFunction(2)
addOne(4)