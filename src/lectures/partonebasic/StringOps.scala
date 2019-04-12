package lectures.partonebasic

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "/"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)
  println(str.reverse)
  println(str.take(2))

  val aNumberString: String = "45"
  val aNumber: Int = aNumberString.toInt

  println(aNumber)

  println('P' +: aNumberString)
  println(aNumberString :+ 'A')
  println("Pre" +: aNumberString)
  println(aNumberString :+ "Ape")

  // Scala-specific: String interpolators

  //S-interpolator
  val name: String = "Ricardo"
  val age: Int = 32
  val greeting: String = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting: String = s"Hello, my name is $name and I am ${age + 1} years old"
  println(anotherGreeting)

  //F-interpolator
  val speed = 1.345f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  //Raw-interpolator
  println(raw"This is a \n newline")
  val escape = "This is a \n newline"
  println(raw"$escape")
}
