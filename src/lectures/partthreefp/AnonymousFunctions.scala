package lectures.partthreefp

object AnonymousFunctions extends App {

  val doubler = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }

  // Anonymous function (LAMBDA)
  val sugarDouble: Int => Int = (x: Int) => x * 2

  //Multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  //No Params
  val justDoSomething: () => Int = () => 3

  //Careful
  println(justDoSomething) //Function itself
  println(justDoSomething()) // Call

  // Curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // Equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // Equivalent to (a,b) => a + b

  /*
  1. MyList: replace all FunctionX calls with lambdas
  2. Rewrite the "special" adder as an anonymous function
   */

  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
}
