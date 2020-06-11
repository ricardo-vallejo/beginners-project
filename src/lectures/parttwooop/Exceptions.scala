package lectures.parttwooop

object Exceptions extends App {

  val x: String = null
  //println(x.length)
  // This ^^ will crash with NPE

  // 1. Throwing exceptions
  //throw new NullPointerException
  //val aWeirdValue: String = throw new NullPointerException

  // Throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtype

  // 2. How to catch exceptions
  def getInt(withException: Boolean): Int =
    if (withException) throw new RuntimeException("No int for you!")
    else 42

  try {
    // Code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught a RuntimeException")
  } finally {
    // Code that will get executed NOT MATTER WHAT
    println("Finally")
  }

  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught a RuntimeException")
  } finally {
    // Optional
    //Does not influence the return type of this expression
    // Use finally only for side effects
    println("Finally")
  }

  // 3. How to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  //throw exception

  /*
   1. Crash your program with an OutOfMemoryError
   2. Crash with SOError
   3. PocketCalculator
    - add(x,y)
    - subtract(x,y)
    - multiply(x,y)
    - divide(x,y)

    Throw
     - OverflowException if add(x,y) exceeds Int.MAX_VALUE
     - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
     - MatchCalculationException for division by 0
   */

  // OOM
  //val array = Array.ofDim(Int.MaxValue)

  //SO
  //def infinite: Int = 1 + infinite
  //val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division  by 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y

      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def devide(x: Int, y: Int): Int = {
      val result = x / y

      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

}
