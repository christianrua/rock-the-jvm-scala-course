package lectures.part1basics

object CallFunctionNameValue extends App {

  def calledByValue (x: Long):Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def callByName(x: => Long):Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  callByName(System.nanoTime())

  //him uses long, because that the kind of data type thats works best with System.nanoTime()
  //in call by name, the expression is evaluated every time that the compiler find it in the function
  //mean while in call by value is evaluated just once

  def infinite (): Int = 1 + infinite()
  def printFirst(x:Int, y: => Int) = println(x)

  //printFirst(infinite(), 34) //this causes a stack over flow
  printFirst(34, infinite()) //but this not, because the y argument is not evaluated in the function

  def printFirst2(x:Int, y: Int) = println(x)
  //printFirst2(34, infinite()) // this also causes a stack over flow, because the argument y is evaluated
  //immediately

}
