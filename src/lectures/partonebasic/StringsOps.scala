package lectures.partonebasic

object StringsOps extends App {

  val string: String = "Hello, I am learning Scala"

  // Java functions
  println(string.charAt(2))
  println(string.substring(7, 11))
  println(string.split(" ").toList)
  println(string.startsWith("Hello"))
  println(string.replace(" ", "-"))
  println(string.toLowerCase)
  println(string.length)

  // Scala functions
  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  println('A' +: aNumberString :+ 'Z') // Pre and Post pending operators

  println(string.reverse)
  println(string.take(5))

  // Scala-specific: String interpolator.

  // S-interpolator
  val name = "Ricardo"
  val age = 33
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I am ${age + 1} years old"

  println(greeting)
  println(anotherGreeting)

  // F-interpolator
  val speed = 1.234f
  println(f"$name can eat $speed%2.2f burgers per minute")

  // Raw-interpolator
  println(raw"This is a \n new line")
}
