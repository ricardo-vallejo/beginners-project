package lectures.parttwooop

object Objects extends App {
  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person {
    // static class level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // Factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String){
    // Instance  level functionality
  }

  // COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala objects = SINGLETON INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  //println(Person.from(mary, john))
  println(Person.apply(mary, john))
  println(Person(mary, john))

  // Scala Applications == Scala Object
  // def main(args: Array[String]): Unit

}
