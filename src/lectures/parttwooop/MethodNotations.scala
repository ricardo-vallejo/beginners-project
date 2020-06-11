package lectures.parttwooop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0){
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    // Exercises
    def +(nickName: String): Person = new Person(s"$name ($nickName)", favoriteMovie)

    def unary_+ : Person = new Person(name, favoriteMovie, age+1)

    def learns(subject: String): String = s"$name is learning $subject"
    def learnsScala : String = this learns "Scala" // Equivalent learns("Scala")

    def apply(times: Int): String = s"$name watched $favoriteMovie $times times"
  }

  val ricardo = new Person("Ricardo", "Cars")

  println(ricardo.likes("Cars"))
  println(ricardo likes "Cars") // Infix notation = operator notation

  // Operators in Scala
  val andrea = new Person("Andrea", "Incredible")
  println(andrea hangOutWith ricardo)

  // ALL OPERATORS ARE METHODS
  println(1 + 2)
  println(1.+(2))

  // Prefix notation
  val x = -1 // Equivalent with 1.unary_-
  val y = 1.unary_- // unary_ prefix ONLY works with - + ~ !

  println(!andrea)
  println(andrea.unary_!)

  //Postfix notation
  println(ricardo.isAlive)
  println(ricardo isAlive)

  // Apply
  println(andrea.apply())
  println(ricardo())

  // Exercises
  println((andrea + "Maximun")())
  println((andrea + "Maximun").apply())
  println((+ricardo).age)
  println(andrea learns "Dibujo")
  println(ricardo learnsScala)
  println(andrea(2))
  println(andrea.apply(2))
}
