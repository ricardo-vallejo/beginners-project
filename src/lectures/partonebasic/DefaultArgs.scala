package lectures.partonebasic

object DefaultArgs extends App {

  def factorialFunction(number: Int, accumulator: Int = 1): Int = {
    if (number <= 1) accumulator
    else factorialFunction(number - 1, number * accumulator)
  }

  val factorial10 = factorialFunction(10, 1) // I can pass the second parameter even if I have a default value.
  val factorial15 = factorialFunction(15) // With a default value I can call the function without the second parameter


  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println(s"Saving picture $format $width $height")

  savePicture() // Call the function without the parameters
  savePicture("bmp") // Call the function just with the first parameter
  savePicture(width = 2048) // Call the function with a specific parameter
  savePicture(height = 3060, width = 2040, format = "gif") // Call the function with the parameters in different order.

}
