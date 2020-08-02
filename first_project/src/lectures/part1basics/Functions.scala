package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b

  println(aFunction("Hello",3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int): String =
    if(n == 1) aString
    else aString +" "+ aRepeatedFunction(aString,n-1)

  println(aRepeatedFunction("hello",3))

  // when you need loops, use recursion.

  def aFunctionWithSideEffects(aString: String):Unit  =
    println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a +b

    aSmallerFunction(n, n-1)
  }

  /*
  1. A greeting function (name, age) => "Hi, my name is $name and i am $age years old"
  2. Factorial function 1 *2 *3 *... * n
  3. A fibonacci function
      f(1) = 1
      f(2) = 1
      f(n) = f(n - 1) + f(n-2)
  4. Test if a number is prime.
   */

  def greeting(name: String, age: Int): Unit =
    println(s"Hi, my name is $name and i am $age years old")

  println("Result of greeting function: ")
  greeting("Christian",33)

  def factorial(n:Int):Int = {
    def aux(n:Int,acc:Int):Int =
      if (n==0) acc
      else aux(n-1,acc*n)

    aux(n,1)
  }

  def shorterFactorial(n: Int):Int =
    if(n <= 0) 1
    else n * shorterFactorial(n-1)

  println("Result of factorial function: ")
  println(factorial(5))

  def fibonacci(n:Int): Int = {
    def aux(n:Int, v1:Int,v2:Int,acc:Int):Int = {
      if(acc==n) v2
      else aux(n,v2,v1+v2,acc+1)
    }

    aux(n,1,1,0)
  }

  def shorterFibonacci(n: Int): Int =
    if(n<=2) 1
    else shorterFibonacci(n-1) + shorterFibonacci(n-2)

  println("Result of fibonacci function: ")
  println(fibonacci(5))

  def ifPrime(n:Int): Boolean = {
    if (n<=1) false
    def aux(n:Int, acc:Int):Boolean = {
      if(acc==n-1) true
      else if(n%acc==0) false
      else aux(n,acc+1)
    }
    aux(n,2)
  }

  def shorterIsPrime(n:Int): Boolean ={
    def isPrimeUntil(t:Int):Boolean =
      if(t<=1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n/2)
  }

  println("Result of ifPrime function: ")
  println(ifPrime(6))
}
