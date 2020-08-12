package lectures.part2oop

object Exceptions extends App {

  val x : String = null
  //println(x.length)  //this will crash with a NPE (Null pointer exception)

  //1. throwing exceptions

  //val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class
  // Exception and Error are the major throwable
  // Exception denote that something that went wrong with the program
  // Error something that happen wrong with the system

  //2 . how to catch exceptions

  def getInt(withExceptions: Boolean):Int =
    if(withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    //code that might fail
    getInt(true)
  }
  catch {
    case e: RuntimeException => println("caught a Runtime exception")
    //case e: NullPointerException => println("caught a Runtime exception")
  }
  finally {
    //code that will executed no MATTER WHAT
    //the finally block is optional, does not influence the return type of this expression
    //use finally only for side effects
    println("finally")
  }

  println(potentialFail)

  //3. how to define you own exceptions
  class MyException extends Exception
  val exception = new MyException

  //throw exception

  /*
  1. Crash you program with an OutOfMemoryError
  */

  //my implementation
  //val firstException = throw new OutOfMemoryError()

  //example implementation OOM == Out Of Memory
  //val array = Array.ofDim(Int.MaxValue)

  /*
  2. crash with SOError
  */

  //my implementation
  //val secondException = throw new StackOverflowError()

  //example implementation SO == Stack Overflow
  // def infinite: Int = 1 + infinite
  // val noLimit = infinite

  /*
  3. PocketCalculator
     - add(x,y)
     - subtract (x, y)
     - multiply(x,y)
     - divide(x,y)

     throw:
     - OverflowException if add(x,y) exceeds Int.MAX_VALUE
     - UnderflowException if subtract exceeds Int.MIN_VALUE
     - MathCalculationException for division by 0

   */

  //my implementation
  class MathCalculationException extends RuntimeException("Division by 0")

object myPocketCalculator {
    def add(x:Int,y:Int) = {
      if( x + y >= Int.MaxValue) throw new StackOverflowError()  //this is bad because x + y will never be grater than Int.MaxValue
      else x + y
    }
    def subtract(x:Int,y:Int) = {
      if( x - y <= Int.MinValue) throw new StackOverflowError()
      else x - y
    }

     def divide (x:Int,y:0) = {
      if( y == 0) throw new MathCalculationException
      else x / y
    }

  def multiply(x:Int, y:Int):Int = x * y

  }

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException

  object PocketCalculator {
    def add(x:Int, y:Int):Int = {
      //here the situation is that x and y > 0, can not be a negative value. and if this
      //situation occurs is because, the number exceeds the size of the type int
      //is the same logic for the rest of implementations
      val result = x + y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def substract (x:Int, y:Int):Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException //see that -(-y) == y
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y:Int):Int = {
      val result = x * y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x:Int, y:Int):Int = {
      if(y==0) throw new MathCalculationException
      else x/y
    }

  }

 // println(PocketCalculator.add(Int.MaxValue,10))
 // println(PocketCalculator.divide(2,0))
}
