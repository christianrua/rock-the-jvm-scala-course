package lectures.part2oop

object CaseClasses extends App {

  /*
  equals, hasCode, toString
   */

  case class Person (name: String, age:Int)

  //1. class parameters are promoted to fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  //2. a sensible toString
  //println(instance) = println(instance.toString) //Syntactic sugar
  println(jim.toString)
  println("this is another way to get access to .toString method")
  println(jim)

  //3. equal and hashCode implemented out of the box(OOTB).
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  //4. case classes (CCs) have handy copy methods
  val jim3 = jim.copy(age=45)  //creates a new instances
  println(jim3)

  //5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)  //in CCs we do not need the new key word

  //6. CCs are serializable
  //Akka

  //7. CCs have extracter patterns = CCs can be used in PATTER MATCHING
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
  Expand MyList - use case classes and case objects
   */
}
