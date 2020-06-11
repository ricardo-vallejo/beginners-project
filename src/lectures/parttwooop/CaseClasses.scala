package lectures.parttwooop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. Class parameters are fields
  val ricardo = new Person("Ricardo", 34)
  println(ricardo.name)

  // 2. Sensible toString
  // println(instance) = println(instance.toString)
  println(ricardo.toString)
  println(ricardo)

  // 3. Equals and hashCode implemented OOTB
  val ricardo2 = new Person("Ricardo", 34)
  println(ricardo == ricardo2)

  // 4. CCs have handy copy method
  val ricardo3 = ricardo.copy(age = 33)
  println(ricardo3)

  // 5. CCs have companion objects
  val thePerson = Person
  val camila = Person("Camila", 22)

  // 6. CCs are serializable
  // 7. CCs have extractor patters = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }



}
