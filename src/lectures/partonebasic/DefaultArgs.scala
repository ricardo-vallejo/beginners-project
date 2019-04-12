package lectures.partonebasic

object DefaultArgs extends App {

  def trFact(number: Int, acc: Int = 1): Int =
    if (number <= 2) acc
    else trFact(number-1, number*acc)

  val fact10 = trFact(10)

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("Saving picture ...")

  savePicture("jpg", 800, 600) //If I don't have default values I have to pass all the values.
  //savePicture(800, 600) //If I have a default value but is a lead value I can't start with the second value.
  savePicture(width = 800, height = 600) //I can solve the previous message if I call every parameter.

  //I can call the parameters in a different order.


}
