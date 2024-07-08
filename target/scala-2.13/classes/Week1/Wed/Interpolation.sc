// S

val name:String = "Jamie"

println(s"My name is $name")

println(s"3x3 = ${3*3}")

val number:Int = 7

println(s"$number x $number = ${number*number}")

// F

// %f - floating point number
// %d - Decimal
// %i - int

val pi:Double = 3.1415926535897
println(f"pi to 2dp is $pi%.2f")
println(f"pi to 4dp is $pi%.4f")
println(f"pi to 2dp but with 16 width $pi%16.4f")

println("Hello \nWorld!") // new line break

printf("'%s'", "hello")
printf("'%s'", name)
printf("'%16s'", name)
printf("'%-16s'", name)

// Raw
println(raw"Hello \nWorld!")

// TESTS
// Task 1

val name1: String = "Thomas"
val name2: String = "Mads"

println(s"$name1 is older than $name2")

// Task 2
val age1: Int = 40
val age2: Int = 34

println(s"$name1 is ${age1-age2}% years older than $name2")

val age1: Double = 40.234
val age2: Double = 34.392

println(f"$name1 is ${age1-age2}%.1f years older than $name2")

// Task 3
println(raw"\n\n\n\n\n\n\n\nsameline\n\n")

val height: Double = 1.6

println(f"$name1 is $height" + "m tall")

printf("%s is %.1fm tall", name1, height)