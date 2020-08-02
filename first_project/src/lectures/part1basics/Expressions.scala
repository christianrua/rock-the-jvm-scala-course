package lectures.part1basics

object Expressions extends App {

  val x = 1 +2  //expression
  println(x)

  println( 2 + 3 * 4 )
  // + - * / & | ^ << >> >>>(right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= .... side effects
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 //IF EXPRESSION
  println(aConditionedValue)
  println(if(aCondition) 5 else 3 )
  println(1 +3)

  var i = 0
  val aWhile = while(i < 10) {
    println(i)
    i += 1
  }

  //NEVER WRITE THIS AGAIN.

  //everything in scala is a expression!

  val aWeirdValue = (aVariable=3) // Unit === void
  println(aWeirdValue)

  //side effects: println(), whiles, reassigning

  //code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if(z>2) "Hello" else "Goodbye"
  }

  //1. difference between "Hello world" vs println("Hello world")?
  //the difference is that "Hello world" is value of type string, and println("Hello world")
  // is a value of type unit and has side effects.

  //2.
  val someValue = {
    2 < 3
  }

  println(someValue)

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }

  println(someOtherValue)

  //the value of someOtherValue is 42 type Int
}
