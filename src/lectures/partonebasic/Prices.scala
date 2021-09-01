package lectures.partonebasic

object Prices extends App {

  val diff: Int =
    pricesComparison(
      Array("eggs", "bread", "milk", "sugar"),
      Array(2.0F, 3.0F, 4.0F, 5.0F),
      Array("eggs", "sugar", "bread", "milk"),
      Array(2.0F, 4.0F, 3.0F, 5.0F)
    )


  def pricesComparison(products: Array[String], prices: Array[Float], soldProducts: Array[String], soldPrices: Array[Float]): Int = {
    var productPricesList: Map[String, Float] = Map()
    var productSoldList: Array[(String, Float)] = Array()

    productPricesList = (products zip prices).toMap
    productSoldList = soldProducts zip soldPrices

    var aux = 0
    productSoldList.foreach{pro =>
      val pri: Float = productPricesList.getOrElse(pro._1, 0f)
      if (pri != pro._2) aux += 1
    }
    aux
  }
}
