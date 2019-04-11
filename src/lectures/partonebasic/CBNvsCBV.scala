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

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = println(x)

  printFirst(infinite(), 34) //This cause a crush of the program by Stack over flow
  printFirst(34, infinite()) //This works because we never use infinite method.
}
