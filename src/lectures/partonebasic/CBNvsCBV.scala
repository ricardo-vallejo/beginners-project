package lectures.partonebasic

object CBNvsCBV extends App {

  def calledByValue(number: Long): Unit = {
    println(s"By value: $number")
    println(s"By value: $number")
  }

  def calledByName(number: => Long): Unit = {
    println(s"By name: $number")
    println(s"By name: $number")
  }

  calledByValue(System.nanoTime()) //Compiler evaluates the expression System.nanoTime() and pass that value to the function
  calledByName(System.nanoTime()) //Compiler pass the expression to the function and the function evaluates the expression.
}
