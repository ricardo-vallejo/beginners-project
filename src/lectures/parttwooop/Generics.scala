package lectures.parttwooop

object Generics extends App {

  class MyList[A] {
    // Use the type A
  }

  class MyMap[Key, Value] {

  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  val mapIntStrings = new MyMap[String, Int]
  val mapDoubleInt = new MyMap[Double, Int]

  // Generics Methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // Variance Problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. Yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ???

  // 2. No = INVARIANCE
  class InvariantList[A]
  val invariantListAnimal: InvariantList[Animal] = new InvariantList[Animal]
  // val invariantListAnimal: InvariantList[Animal] = new InvariantList[Cat] -> You should declare the same kind of object.

  // 3. Hell, no!! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // Bounded Types
  /*
  <: Receive a subclass of the Class
  >: Receive a superclass of the Class
   */
  class Cage[A <: Animal](animal: A)
  val dogCage = new Cage(new Dog)

  class Car
  // val carCage = new Cage(new Car) -> Generate a type mismatch error.

  class MyNewList[+A] {
    // def add(element: A): MyNewList[A] = ??? -> This is an error because the new list could be a different type of list
    def add[B >: A](element: B): MyNewList[B] = ??? // This is OK because the new list could be a different super type of the list
  }
}
