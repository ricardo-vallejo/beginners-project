package lectures.parttwooop

object OOBasic extends App {

  val person = new Person("Ricardo", 33)
  println(person.xNumber)
  person.greet("Alfonso")

  val writer = new Writer("Ricardo", "Vallejo", 1987)
  val impostor = new Writer("Ricardo", "Vallejo", 1987)
  val novel = new Novel("New Methods", 2019, writer)

  writer.authorFullName()
  println(s"The age of the author is: ${novel.authorAge()}")
  println(s"The novel was written by: ${novel.authorName()}")
  println(novel.isWrittenBy(impostor))

  val counter = new Counter()

  counter.increment.increment.print()
  counter.increment(10).print()
}

// Constructor
// Class parameters are NOT fields
class Person(name: String, age: Int) {
  // Body of the class
  val xNumber = 2
  println("My class person")

  // Methods
  def greet(name: String): Unit = println(s"${this.name} says: Hi $name") // Use "this" to call class parameters

  // Overloading (Methods with the same name but different parameters or signatures)
  def greet(): Unit = println(s"Hi, I am $name")

  // Multiple constructors (An auxiliary constructor only can be another constructor)
  def this(name: String) = this(name, 0)
  def this() = this("Jhon Doe")
}

/*
 Novel and Writer

 Writer: first name, surname, year of birth
  - method full name

 Novel: name, year of release, author
  - author age
  - is writing by
  - copy (new year of release) = new instance of novel
 */

class Writer(val firstName: String, val sureName: String, val birthYear: Int) {
  def authorFullName(): String = s"$firstName $sureName"
}

class Novel(name: String, releaseYear: Int, author: Writer) {
  def authorAge(): Int = releaseYear - author.birthYear
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def authorName(): String = author.authorFullName()
  def copyNovel(newReleaseYear: Int): Novel = new Novel(this.name, newReleaseYear, this.author)
}

/*
Counter class
 - receives an int value
 - method current count
 - method to increment/decrement => new counter
 - overload inc/dec to receive an amount
 */

class Counter(val number: Int = 0) {
  def increment: Counter = {
    println("Incrementing")
    new Counter(number + 1) //Inmutability
  }

  def decrement: Counter = {
    println("Decrementing")
    new Counter(number - 1)
  }

  def increment(amount: Int): Counter = {
    if (amount <= 0) this
    else increment.increment(amount-1)
  }

  def decrement(amount: Int): Counter = {
    if (amount <= 0) this
    else decrement.decrement(amount - 1)
  }

  def print(): Unit = println(number)
}

