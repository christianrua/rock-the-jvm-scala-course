package exercises

abstract class MyList {
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

  def head:Int
  def tail:MyList
  def isEmpty:Boolean
  def add(element:Int):MyList
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"

}

//??? returns nothing
object Empty extends MyList {
  def head:Int = throw new NoSuchElementException
  def tail:MyList = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def add(element:Int):MyList = new Cons(element, Empty)
  def printElements: String = ""
}

class Cons(h:Int, t:MyList) extends MyList {
  def head:Int = h
  def tail:MyList = t
  def isEmpty:Boolean = false
  def add(element:Int):MyList = new Cons(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {

  val list = new Cons(1,Empty)
  println("this is the first list")
  println(list.head)
  println("adding a new element")
  println(list.add(4).head)
  println(list.isEmpty)
  println(list.toString)

  val list2 = new Cons(1,new Cons(2, new Cons(3, Empty)))
  println("this is the second list")
  println(list2.tail.head)
  println(list2.tail.tail.head)
  println(list2.toString)
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