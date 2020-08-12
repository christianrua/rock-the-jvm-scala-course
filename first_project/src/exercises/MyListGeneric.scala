package exercises

abstract class MyListGeneric[+A] {
  /*
  liked list of integers
  head = first element of the list (int)
  tail = remainder of the list
  isEmpty = is this ist empty
  add(int) => new list with this new element added
  override the method toString => return a string representation of the list
   */

  /* this is my implementation
  def head:Int
  def tail:List[Int]
  def isEmpty:Boolean
  def add:List[Int]

  override def toString: String = s"the list contain $head and $tail"

   */

  def head:A
  def tail:MyListGeneric[A]
  def isEmpty:Boolean
  def add[B >: A](element:B):MyListGeneric[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
  def map[B](function:MyTransformer[A,B]): MyListGeneric[B]
  def filter(condition: Mypredicate[A]): MyListGeneric[A]
  def flatMap[B](function:MyTransformer[A,MyListGeneric[B]]):MyListGeneric[B]
  //concatenation
  def ++[B >: A](list: MyListGeneric[B]): MyListGeneric[B]
}

//??? returns nothing
//object EmptyGeneric extends MyListGeneric[Nothing] {
case object EmptyGeneric extends MyListGeneric[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail:MyListGeneric[Nothing] = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def add[B >: Nothing](element:B):MyListGeneric[B] = new ConsGeneric(element, EmptyGeneric)
  def printElements: String = ""

  def map[B](function:MyTransformer[Nothing,B]) = EmptyGeneric
  def filter(condition: Mypredicate[Nothing]):MyListGeneric[Nothing] = EmptyGeneric
  def flatMap[B](function:MyTransformer[Nothing,MyListGeneric[B]]):MyListGeneric[Nothing]= EmptyGeneric

  def ++[B >: Nothing] (list: MyListGeneric[B]): MyListGeneric[B] = list
}

//class ConsGeneric[+A](h:A, t:MyListGeneric[A] ) extends MyListGeneric[A]  {
case class ConsGeneric[+A](h:A, t:MyListGeneric[A] ) extends MyListGeneric[A]  {
  def head:A = h
  def tail:MyListGeneric[A]  = t
  def isEmpty:Boolean = false
  def add[B >: A](element:B):MyListGeneric[B]  = new ConsGeneric(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
  /*
    [1,2,3].map(n * 2)
    = new ConsGeneric(2 ,[2,3].map(n * 2))
    = new ConsGeneric(2, new ConsGeneric(4, [3].map(n * 2)))
    = new ConsGeneric(2, new ConsGeneric(4, new ConsGeneric(6 , EmptyGeneric.map(n * 2))))
    = new ConsGeneric(2, new ConsGeneric(4, new ConsGeneric(6, EmptyGeneric)))
   */
  def map[B](f:MyTransformer[A,B]): MyListGeneric[B] =
    new ConsGeneric(f.transform(h),t.map(f))
    //if(t.isEmpty) this
    //else f.transform(this.head)::t.map(f)
 /*
  [1,2,3].filter(n % 2 == 0) =
  [2,3].filter(n % 2 == 0) =
    = new ConsGeneric(2 ,[3].filter(n % 2 == 0))
    = new ConsGeneric(2, EmptyGeneric.filter(n % 2 == 0))
    = new ConsGeneric(2, EmptyGeneric)
  */
  def filter(predicate: Mypredicate[A]): MyListGeneric[A] =
    if(predicate.test(h)) new ConsGeneric(h, t.filter(predicate))
    else t.filter(predicate)

  /*
  [1,2] ++ [3,4,5]
  = new ConsGeneric(1, [2] ++ [3, 4, 5])
  = new ConsGeneric(1, new ConsGeneric(2, EmptyGeneric ++ [3,4,5]))
  = new ConsGeneric(1, new ConsGeneric(2 ,new ConsGeneric(3, new ConsGeneric(4 , new ConsGeneric(5)))))
   */
  def ++[B >: A](list: MyListGeneric[B]): MyListGeneric[B] = new ConsGeneric(h, t ++ list)

  /*
  [1,2].flatMap(n => [n, n+1])
  = [1,2] ++ [2].flatMap(n => [n, n+1])
  = [1,2] ++ [2,3] ++ EmptyGeneric.flatMap(n => [n, n+1])
  = [1,2] ++ [2,3] ++ EmptyGeneric
  = [1,2,2,3]
   */
  def flatMap[B](f:MyTransformer[A,MyListGeneric[B]]):MyListGeneric[B]=
   f.transform(h) ++ t.flatMap(f)

}





/*
  1. Generic trait MyPredicate[-T] have a small method test(T) => Boolean, to test where a value
  of type T passes the condition
*/
trait Mypredicate[-T]{
  def test(elem:T): Boolean
}
/*
  2. Generic trait MyTransformer[-A,B] have a method to convert a value of type A to type B
  with a method call transform(A) => B
*/
trait MyTransformer[-A,B]{
  def transform(elem:A):B
}
/*
  3. Mylist:
      - define a method called map, that takes the transformer and returns a new instance of Mylist
        - map(transformer) => MyList
        - filter(predicate) => MyList
        - flatMap(transformer from A to Mylist[B]) => Mylist[B]

        examples:

        class EvenPredicate extends MyPredicate[Int]
        class StringToIntTransformer extends MyTransformer[String, Int]

        [1,2,3].map(n * 2) = [2,4,6]
        [1,2,3,4].filter(n%2) = [2,4]
        [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
   */


object ListTest2 extends App {

  val listOfIntegers: MyListGeneric[Int] = new ConsGeneric(1,new ConsGeneric(2, new ConsGeneric(3, EmptyGeneric)))
  val cloneListOfIntegers: MyListGeneric[Int] = new ConsGeneric(1,new ConsGeneric(2, new ConsGeneric(3, EmptyGeneric)))
  val anotherListOfIntegers: MyListGeneric[Int] = new ConsGeneric(4, new ConsGeneric(5, EmptyGeneric))
  val listOfStrings: MyListGeneric[String] = new ConsGeneric("Hello", new ConsGeneric("Scala",EmptyGeneric))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem:Int):Int = elem * 2
  }).toString)

  println(listOfIntegers.filter(new Mypredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString)

  println((listOfIntegers++anotherListOfIntegers).toString)
  println(listOfIntegers.flatMap(new MyTransformer[Int, MyListGeneric[Int]]{
    override def transform(elem: Int):MyListGeneric[Int] =
      new ConsGeneric[Int](elem, new ConsGeneric[Int](elem+1, EmptyGeneric))
  }).toString)

  println(cloneListOfIntegers==listOfIntegers)
}
/*
this is my implementation
class likedList(list:List[Int]) extends MyList {

  def head = list match {
    case x::xs => x
  }

  def tail = list match {
    case x::xs => xs
  }

  def isEmpty = list match {
    case Nil => true
    case x::xs => false
  }

  def add(elem:Int) = elem::list

}
*/