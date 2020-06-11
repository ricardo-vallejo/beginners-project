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

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]

  // Concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

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
  override def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(firstE)) new Cons(firstE, remainedE.filter(predicate))
    else remainedE.filter(predicate)

  /*
   [1,2,3].map(n * 2)
    = new Cons(2, [2,3].map(n * 2))
    = new Cons(2, new Cons(4, [3].map(n * 2)))
    = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
    = new Cons(2, new Cons(4, new Cons(6, Empty)))
   */
  override def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new Cons(transformer.transform(firstE), remainedE.map(transformer))

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
  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(firstE) ++ remainedE.flatMap(transformer)
}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
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

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString)

  println(listOfIntegers ++ anotherListOfIntegers)

  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = new Cons[Int](elem, new Cons[Int](elem + 1, Empty))
  }).toString)

}