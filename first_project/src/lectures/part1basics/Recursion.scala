package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if(n<=1) 1
    else {
      println("Computing factorial of "+ n + "- I first need factorial of "+ (n-1))
     val result =  n * factorial(n-1)
      println("Computing factorial of "+ n )
      result
    }
  }

  println(factorial(10))
 // println(factorial(5000)) //this causes a Stack overflow

  def anotherFactorial(n: Int): BigInt ={
    @tailrec
    def facHelper(x: Int, acc: BigInt): BigInt =
      if(x <= 1) acc
      else facHelper(x-1, x*acc) //Tail recursion = use recursive call as the LAST expression

    facHelper(n,1)
  }

  /*
    anotherFactorial(10)= factHelper(10,1)
    = factHelper(9,10*1)
    = factHelper(8,9*10*1)
    = factHelper(7,8*9*10*1)
    = factHelper(6,7*8*9*10*1)
    = ...
    = factHelper(2,3*4*...*8*9*10*1)
    = factHelper(1,1*2*3*4*...*8*9*10)
    = 1*2*3*4*...*8*9*10
   */

  println(anotherFactorial(5000))

  // when you need loops, use tail recursion.

  /*
  1. Concatenates a string n times using tail recursion
  2. isPrime function tail recursive
  3. Fibonacci function tail recursive
   */

  @tailrec
  def concatenateNtimes(aString:String, n:Int, acc:String):String =
    if(n<=0) acc
    else concatenateNtimes(aString,n-1,acc+n+" "+aString)

  println(concatenateNtimes("Say no to drugs ",10,""))




  def isPrimeMine(n:Int): Boolean = {
    //if (n<=1) false
    @tailrec
    def aux(n:Int, acc:Int):Boolean =
      if(acc==n-1) true
      else if(n%acc==0) false
      else aux(n,acc+1)

    aux(n,2)
  }

  //another implementation of is prime in a tail recursive way

  def isPrimeNew(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime:Boolean): Boolean =
      if(!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t-1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n/2, true)
  }

  println(isPrimeMine(2003))
  println(isPrimeNew(2003))


  def fibonacci(n:Int): Int = {
    def aux(n:Int, v1:Int,v2:Int,acc:Int):Int = {
      if(acc==n) v1
      else aux(n,v2,v1+v2,acc+1)
    }

    aux(n,1,1,0)
  }

  def anotherFibonnaci(n:Int):Int = {
    def fiboTailrec(i: Int, last:Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i+1, last + nextToLast, last)

    if(n<=2) 1
    else fiboTailrec(2,1,1)
  }

  println(fibonacci(7))
  println(anotherFibonnaci(8))
}
