package lectures.partonebasic

object Expressions extends App {

  val addition: Int = 1 + 2
  println(addition)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == addition)
  // == != > >= < <=

  println(!(1 == addition))
  // ! && ||

  var aVariable = 2
  aVariable += 3 //Also works with -= *= /=
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3 // IF expression
  println(aConditionValue)
  println(if (aCondition) 5 else 3)

  var i = 0
  while (i < 10){
    println(i)
    i += 1
  }

  //NEVER write this again

  //EVERYTHING in Scala is an Expression

  val aWeirdValue = (aVariable = 3) //Unit === void
  println(aWeirdValue)

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }


}
