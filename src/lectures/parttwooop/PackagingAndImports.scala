package lectures.parttwooop

import java.sql

import lectures.partonebasic.DefaultArgs.savePicture
import playground.{PrinceCharming, Cinderella => Princess}

import java.util.Date
import java.sql.{Date => SqlDate} // Aliasing

object PackagingAndImports extends App {

  // Package members are accessible by their simple name
  val writer = new Writer("Ricardo", "Vallejo", 2018)

  // Import the package
  val saveNewImage: Unit = savePicture()
  val newImage: Unit = lectures.partonebasic.DefaultArgs.savePicture() // Fully qualified name

  val princess =  new Princess
  val newPrincess = new playground.Cinderella

  // Package are hierarchy
  // Matching folder structure

  // Package object
  sayHello()
  println(SPEED_OF_LIGHT)

  //Imports
  val prince = new PrinceCharming

  val date = new Date()
  // 1. Use FQ names
  val sqlDate = new java.sql.Date(2018, 5, 4)
  // 2. Use aliasing
  val newSqlDate = new SqlDate(2018, 5, 4)

  // Default imports
  // java.lang -> Strings, Object, Exceptions
  // scala -> Int, Nothing, Function
  // scala.Predef -> println, ???

}
