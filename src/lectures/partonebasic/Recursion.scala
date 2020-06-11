package lectures.partonebasic

object Recursion extends App {

  def factorial(number: Int): Int = {
    if (number <= 1) 1
    else {
      println(s"Computing factorial of $number - I first need factorial of ${number - 1}")
      val result = number * factorial(number - 1)
      println(s"Computed factorial of $number")
      result
    }
  }

  factorial(10)
  //factorial(5000) <-- This cause StackOverflowError

  def anotherFactorial(number: Int): BigInt = {
    def factorialHelper(aux: Int, accum: BigInt): BigInt = {
      if (aux <= 1) accum
      else factorialHelper(aux - 1, aux * accum) // TAIL RECURSION = Use recursive call as the LAST expression.
    }
    factorialHelper(number, 1)
  }

  /*
  anotherFactorial(10) = factorialHelper(10, 1)
  = factorialHelper(9, 10 * 1)
  = factorialHelper(8, 9 * 10 * 1)
  = factorialHelper(7, 8 * 9 * 10 * 1)
    ....
  = factorialHelper(2, 3 * 4 * 5 * .... * 1)
  = factorialHelper(1, 2 * 3 * 4 * 5 * .... * 1)
  = 1 * 2 * 3 * .... * 10
   */

  println(anotherFactorial(5000)) // <-- This works with big numbers.

  // You should use TAIL RECURSION when you need loops.

  /*
  1. Concatenate a string n time
  2. IsPrime function tail recursive
  3. Fibonacci function tail recursive
   */

  def concactString(phrase: String, number: Int): String = {
    @scala.annotation.tailrec
    def stringHelper(aux: Int, accum: String): String = {
      if (aux <= 1) accum
      else stringHelper(aux - 1, accum + phrase)
    }
    stringHelper(number, phrase)
  }

  @scala.annotation.tailrec
  def concatenateTailRec(aString: String, number: Int, accumulator: String = ""): String =
    if (number <= 0) accumulator
    else concatenateTailRec(aString, number - 1, aString + accumulator)

  println(concactString("Hello", 5))
  println(concatenateTailRec("Hello", 4))


  def isPrime(number: Int): Boolean = {
    @scala.annotation.tailrec
    def isPrimeTailRec(aux: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (aux <= 1) true
      else isPrimeTailRec(aux - 1, number % aux != 0 && isStillPrime)

    isPrimeTailRec(number / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacciFunction(number: Int): Int = {
    def fiboHelper(aux: Int, accum: Int, accum2: Int): Int = {
     if (aux >= number) accum
     else fiboHelper(aux + 1, accum + accum2, accum)
    }

    if (number <= 2) 1
    else fiboHelper(2, 1, 1)
  }

  println(fibonacciFunction(8))
}

