package lectures.part1basics

object StringOps extends App {

  val str:String = "Hello, i am learning Scala"

  //Java functions from the String class
  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ","-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') // +: is the operator for pre pendding and :+ is the operator
  println(str.reverse)                 // for appending
  println(str.take(2))

  //Scala specific: String interpolators

  //S-interpolators
  val name = "Christian"
  val age = 33
  val greeting = s"Hello, my name is $name and I am $age years old" //the s inyects the value of the vals after the $ sign
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"

  println(anotherGreeting)

  // F- Interpolators

  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"  //%2.2f means 2 characters with 2 digits of precision
  // the % simbol is for represents the format, for example %s is for string format
  println(myth)

  // raw - interpolator
  println(raw"this is a \n newline")
  val escaped = "this is a \n newline"
  println(raw"$escaped")
}
