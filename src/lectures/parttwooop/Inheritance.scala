package lectures.parttwooop

object Inheritance extends App {

  class Animal {
    // Only can be access in this class
    private def animalName(): Unit = println("Dante")

    // Can be access in this class and child classes
    protected def animalType(): Unit = println("Feline")

    // Public
    def eat(): Unit = println("nomnom")

    val breed = "Angora"
  }

  class Cat extends Animal{
    def domestic(): Unit = {
      animalType()
      println("Miauu")
    }
  }

  val dante = new Cat
  dante.eat()

  // Constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)
  class AdultTwo(name: String, age: Int, idCard: String) extends Person(name)

  // Overriding
  class Dog(override val breed: String) extends Animal {
    override def eat(): Unit = println("crunch crunch")
  }

  class KillerDog extends Animal {
    override val breed: String = "Alaska Malamute"
  }

  val poncho = new Dog("Siberian")
  poncho.eat()
  println(poncho.breed)

  val daemon = new KillerDog
  println(daemon.breed)

  // Type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat()

  // Super
  class NewDog extends Animal {
    override def eat(): Unit = {
      super.eat()
      println("ñam ñam")
    }
  }

  val brandi = new NewDog
  brandi.eat()

  // Preventing overrides
  /*
  1. Using final on the method or value
  2. Using final on the class
  3. Seal the class = extend classes in THIS FILE but prevent extension in other files (sealed)
   */

}
