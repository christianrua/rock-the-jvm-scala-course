package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Lennin", 33)
  println(person.x)
  person.greet("Christian")
  person.greet()

  val writer1 = new Writer("Rua","Remache",1987)
  println(writer1.fullName)

  val novel1 = new Novel("learning to code", 2005,writer1)
  println(novel1.authorAge())
  println(novel1.isWrittenBy(writer1))

  val novel1Copy = novel1.copy(2008)
  println(novel1Copy.authorAge())

  val testCounter = new Counter
  testCounter.inc.print
  testCounter.inc.inc.inc.print
  testCounter.inc(10).print
  /*
  println(testCounter.currentCount())

  val testCounter1 = testCounter.incrementDecrement(true)
  println(testCounter1.currentCount())

  val testCounter2 = testCounter.incrementDecrement(true,5)
  println(testCounter2.currentCount())
   */



}

//constructor
class Person(name: String,val age:Int) {
  //class body
  //class parameters are NOT FIELDS. to converted them to fields you have to put the key word val or var
  //accordingly to your design, and in that way you can used it like a fields.
  val x = 2

  println(1+3)
  //method
  def greet(name:String): Unit = println(s"${this.name} says: hi, $name") //we have to use this here, because we need to specified the correct argument

  //overloading
  def greet(): Unit = println(s"Hi, i am $name")

  //multiple constructors
  def this (name: String) = this(name,0)
  def this () = this("John Doe")

}

/*
Exercises

Novel and Writer

writer: first name, surname, year of birth
  - method fullname

Novel: name, year of release, author
  - method authorAge - return the age of the year of release
  - method isWrittenBy(author)
  - copy (new year of release) = new Instance of novel

 */
class Writer(firstName:String, surName:String, val yearBirth:Int){
  def fullName():String = firstName +" "+ surName
}

class Novel(name:String, yearRelease:Int, author:Writer){
  def authorAge():Int = yearRelease - author.yearBirth
  def isWrittenBy(author: Writer) = author == this.author
  //def isWrittenBy():String = author.fullName()
  def copy(newYearRelease:Int):Novel = new Novel(this.name, newYearRelease, this.author)
}

/*
Counter class
  -receives an int value
  - method current count
  -method to increment/decrement by 1 => new counter
  -overload inc/dec to receive an amount
 */

//class Counter(x:Int){
class Counter(val count:Int=0){
  //def currentCount():Int = this.x
  def inc = {
    println("incrementing")
    new Counter(count +1) //immutability
  }
  def dec = {
    println("decrementing")
    new  Counter(count -1)
  }

  def inc(n:Int) : Counter =
    if(n <= 0) this
    else inc.inc(n-1)

  def dec(n:Int) :Counter =
    if(n <= 0) this
    else dec.dec(n-1)

  def print = println(count)

  //def incrementDecrement(y:Boolean):Counter = if(y) new Counter(this.x +1) else new Counter(this.x-1)
  //def incrementDecrement(y:Boolean,z:Int):Counter = if(y) new Counter(this.x + z) else new Counter(this.x-z)
}
