package lectures.parttwooop

object OOBasic extends App {

  val person: Person = new Person("Ricardo", 32)

  println(person.age) //I can call a Field
  println(person.number) //I can call a variable declared inside the class.
  person.greet("Pedro") //I can call a method inside the class
  person.greet()

  val personDefName: Person = new Person()
  println(personDefName)

  val personDefAge: Person = new Person("Pedro")
  println(personDefAge)

  val author: Writer = new Writer("Ricardo", "Vallejo", 1987)
  val novel: Novel = new Novel("The new book", 2017, author)

  println(author.fullName())
  println(novel.authorAge())
  println(novel.isWritingBy(author))
  println(novel.copy(2019))

}

//Constructor
class Person(name: String, val age: Int) {
  val number: Int = 3

  println(1 + 3)

  //Method
  def greet(name: String): Unit =
    println(s"${this.name} says: Hi, $name") // "this" use the parameter of the class when I have a parameter in the method with the same name.

  //Overloading : Define the same method name but with different parameters
  def greet(): Unit =
    println(s"Hi, I am $name") //If I don't have parameter in the method I don't have to use "this"

  //Multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("Jhon Doe")
}

//Class parameters are NOT FIELDS
//Add VAL or VAR to a parameter to convert into a field.

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName(): String = s"$firstName $surname"
}

class Novel(name: String, yearRelease: Int, author: Writer) {
  def authorAge(): Int = yearRelease - author.year
  def isWritingBy(author: Writer): Boolean = author == this.author
  def copy(newYearRelease: Int): Novel = new Novel(name, newYearRelease, author)
}

class Counter(val count: Int) {
  def increment: Counter = {
    println("Incrementing")
    new Counter(count + 1) //Inmutability
  }

  def decrement: Counter = {
    println("Decrementing")
    new Counter(count - 1)
  }

  def increment(n: Int): Counter = {
    if (n <= 0) this
    else increment.increment(n - 1)
  }

  def decrement(n: Int): Counter = {
    if (n <= 0) this
    else decrement.decrement(n - 1)
  }

  def print = println(count)
}
