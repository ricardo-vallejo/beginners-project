package lectures.partthreefp

object WhatsAFunction extends App {

  // DREAM: use functions as first class elements
  // PROB: OOP

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // Function types = Function1[A,B]
  val stringToIntConverter: (String => Int) = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  // Function type Function[A, B, R] === (A, B) -> R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
   1. A function which take 2 strings and concatenates them
   2. Transform the MyPredicate and MyTransform into functions types
   3. Define a function which takes an Int and returns another function which takes an Int and returns an Int
    - What's the type of this function
    - How to do it
   */

  // V1
  val concatenate = new ((String, String) => String) {
    override def apply(v1: String, v2: String): String = s"$v1 $v2"
  }

  println(concatenate("Scala", "Rocks"))

   // V2
  def concatenator: (String, String) => String =
    new Function2[String, String, String] {
      override def apply(v1: String, v2: String): String = s"$v1 $v2"
    }

  // Function1[Int, Function1[Int, Int]]
  val superAdder: Function1[Int, Function1[Int, Int]] =
    new Function1[Int, Function1[Int, Int]] {
      override def apply(x: Int): Function1[Int, Int] =
        new Function1[Int, Int] {
          override def apply(y: Int): Int = x + y
        }
    }

  val adder3 = superAdder(3)
  println(adder3(5))

  println(superAdder(3)(4)) // Curried Function

}

trait MyFunction[A, B] {
  def apply(element: A): B
}
