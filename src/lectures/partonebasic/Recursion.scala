package lectures.partonebasic

import scala.annotation.tailrec

object Recursion extends App {

  //Recursive method to run small numbers
  def factorialFunction(number: Int): Int = {
    if (number <= 0) 1
    else {
      println(
        s"Computing factorial of $number - I first need factorial of ${number - 1}")
      val result = number * factorialFunction(number - 1)
      println(s"Computed factorial of $number")
      result
    }
  }

  println(factorialFunction(10))

  //Recursive methods to run big numbers
  def bigNumberFactorial(number: Int): BigInt = {
    @tailrec
    def factorialHelper(auxiliary: Int, accumulator: BigInt): BigInt = {
      if (auxiliary <= 0) accumulator
      else
        factorialHelper(auxiliary - 1, auxiliary * accumulator) //Tail recursion = use recursive call as the LAST expression
    }

    factorialHelper(number, 1)
  }

  println(bigNumberFactorial(400))

  //Recursive Methods
  def aRepeatedFunction(aString: String, n: Int): String = {
    @tailrec
    def concatenateHelper(aux: Int, accumulator: String): String =
      if (aux == 1) accumulator
      else concatenateHelper(aux - 1, aString + accumulator)

    concatenateHelper(n, aString)
  }

  @tailrec
  def concatenateTailRecord(aString: String,
                            number: Int,
                            accumulator: String): String =
    if (number <= 0) accumulator
    else concatenateTailRecord(aString, number - 1, aString + accumulator)

  println(concatenateTailRecord("Hello ", 5, ""))
  println(aRepeatedFunction("Repeat ", 5))

  def isPrime(number: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(aux: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (aux <= 1) true
      else isPrimeTailRec(aux - 1, number % aux != 0 && isStillPrime)

    isPrimeTailRec(number / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacciFunction(number: Int): Int = {
    @tailrec
    def fibHelper(aux: Int, last: Int, nextToLast: Int): Int = {
      if (aux >= number) last
      else fibHelper(aux + 1, last + nextToLast, last)
    }

    if (number <= 2) 1
    else fibHelper(2, 1, 1)
  }

  println(fibonacciFunction(8))

}
