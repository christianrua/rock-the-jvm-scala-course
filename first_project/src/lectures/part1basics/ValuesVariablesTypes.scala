package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x = 42
  println(x)

  // vals are immutable

  //compiler can infer types

  val aString: String = "Hello"
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4612
  val aLong: Long = 234563654645L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  //variables
  var aVariable: Int = 4

  aVariable = 5 //side effects

}
