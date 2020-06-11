package lectures.partonebasic

object Functions extends App {

  def aFunction(aParam: String, bParam: Int): String = aParam + " " + bParam

  def aSecondFunction(aString: String, aInt: Int): String = {
    aString + " " + aInt
  }

  println(aFunction("Hello", 3))
  println(aSecondFunction("Hello", 4))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  // Recursive function
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("Repeat ", 3))

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(aInt: Int): Int = {
    def aSmallFunction(aInt: Int, bInt: Int): Int = aInt + bInt

    aSmallFunction(aInt, aInt + 1)
  }

  def presentationFunction(name: String, age: Int): Unit = {
    println(s"Hello, my name is $name and I am $age years old")
  }

  presentationFunction("Ricardo", 32)

  def factorialFunction(number: Int): Int = {
    if (number <= 0) 1
    else number * factorialFunction(number - 1)
  }

  println(s"Factorial Function: ${factorialFunction(5)}")

  def fibonacciFunction(number: Int): Int = {
    if (number <= 2) 1
    else fibonacciFunction(number - 1) + fibonacciFunction(number - 2)
  }

  println(s"Fibonacci Function: ${fibonacciFunction(8)}")

  def primeNumberFunction(number: Int): Boolean = {
    @scala.annotation.tailrec
    def isPrimeUntil(aux: Int): Boolean =
      if (aux <= 1) true
      else number % aux != 0 && isPrimeUntil(aux -1)

    isPrimeUntil(number / 2)
  }

  println(s"Is number prime ${primeNumberFunction(38)}")

}
