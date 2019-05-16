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

}

//Constructor
class Person(name: String, val age: Int) {
  val number: Int = 3

  println(1 + 3)

  //Method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name") // "this" use the parameter of the class when I have a parameter in the method with the same name.

  //Overloading : Define the same method name but with different parameters
  def greet(): Unit = println(s"Hi, I am $name") //If I don't have parameter in the method I don't have to use "this"

  //Multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("Jhon Doe")
}

//Class parameters are NOT FIELDS
//Add VAL or VAR to a parameter to convert into a field.
