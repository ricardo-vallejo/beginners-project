package lectures.parttwooop

object AbstractDataTypes extends App {

  // Abstract
  abstract class Animal {
    val creatureType: String
    def eat(): Unit
  }

  /*
  val animalTest = new Animal
  Abstract classes can be instantiated.
  To use an Abstract class we must use extend.
   */

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat(): Unit = println("Crunchy") // Override is not mandatory
  }

  // Traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Crocodile"
    override def eat(): Unit = println("Croc Croc")

    override def eat(animal: Animal): Unit = println(s"I'm a Croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val crocodile = new Crocodile
  crocodile.eat(dog)

  // Traits vs Abstracts
  /*
  1. Traits do not have constructor parameters
  2. Multiple traits may be inherited by the same class. Abstract NO.
  3. Traits = Behavior. Abstracts = Things.
   */
}
