package exercises

abstract class MyList[+A] {

  /*
  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty
  add(Int) = new list with this element added
  toString = a string representation of the list
   */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = s"[$printElements]"

  // Higher order functions
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  // Concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](firstE: A, remainedE: MyList[A]) extends MyList[A] {
  def head: A = firstE
  def tail: MyList[A] = remainedE
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String =
    if (remainedE.isEmpty) s"$firstE"
    else s"$firstE ${remainedE.printElements}"

  /*
   [1,2,3].filter(n % 2 == 0)
    = [2, 3].filter(n % 2 == 0)
    = new Cons(2, [3].filter(n% % 2 == 0))
    = new Cons(2, Empty.filter(n% % 2 == 0))
    = new Cons(2, Empty)
   */
  override def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(firstE)) new Cons(firstE, remainedE.filter(predicate))
    else remainedE.filter(predicate)

  /*
   [1,2,3].map(n * 2)
    = new Cons(2, [2,3].map(n * 2))
    = new Cons(2, new Cons(4, [3].map(n * 2)))
    = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
    = new Cons(2, new Cons(4, new Cons(6, Empty)))
   */
  override def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(firstE), remainedE.map(transformer))

  /*
   [1,2] ++ [3,4,5]
   = new Cons(1, [2] ++ [3,4,5])
   = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
   = new Cons(1, new Cons(2, [3,4,5]))
   = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
   */
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(firstE, remainedE ++ list)

  /*
   [1,2].flatMap(n => [n, n+1])
    = [1,2] ++ [2].flatMap(n => [n, n+1])
    = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
    = [1,2] ++ [2,3] ++ Empty
    = [1,2,2,3]
   */
  override def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(firstE) ++ remainedE.flatMap(transformer)
}

object ListTest extends App {
  val listTest = new Cons(1, Empty)
  val newListTest = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(listTest.head) // Returns 1
  println(listTest.tail) // Returns a instance of Empty
  println(listTest.add(4).head)
  println(listTest.isEmpty)

  println(listTest.toString)
  println(newListTest.toString)

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map((element:Int) => element * 2).toString)
  println(listOfIntegers.map(_ * 2).toString)

  println(listOfIntegers.filter((elem: Int) => elem % 2 == 0).toString)
  println(listOfIntegers.filter(_ % 2 == 0).toString)

  println(listOfIntegers ++ anotherListOfIntegers)

  println(listOfIntegers.flatMap((elem: Int) => new Cons[Int](elem, new Cons[Int](elem + 1, Empty))).toString)

}