package lectures.parttwooop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat(): Unit
  }

  // Anonymous Class
  val funnyAnimal: Animal = new Animal {
    override def eat(): Unit = println("Hahahahahaha")
  }
  /*
    class AnonymousClasses$$anon$1 extend Animal {
      override def eat(): Unit = println("Hahahahahaha")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi(): Unit = println(s"Hello my name is ${name}, How can I help you?")
  }

  val ricardo = new Person("Ricardo") {
    override def sayHi(): Unit = println(s"Hello my name is Ricardo, How can I help you today?")
  }
  ricardo.sayHi()

}
