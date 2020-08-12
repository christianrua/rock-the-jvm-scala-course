package lectures.part2oop

object Objects extends App {

    // Scala does not have class level funtionality (no concept of "static")
    // the Scala object has a Static like functionality
    object Person {
      //objects do not recive parameters
      // in this you define the type + its only instance
      //"static"/"class" - level functionality
      val N_EYES = 2
      def canFly: Boolean = false
      //this function is call a factory method
      def apply(mother:Person, father:Person) = new Person("the same name")
    }

    class Person (name:String) {
      //instance-level functionality
    }
  //the pathern of classes and objects with the same name and the same scope, is call
  // companions


  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  println("This is the object part, is the same instance")
  val maryObject = Person
  val johnObject = Person


  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  println("This is the class part, did not be the same instance")
  val maryClass = new Person ("mary")
  val johnClass = new Person("john")

  println(maryClass== johnClass)

  //factory method section
  val bobbie = Person(maryClass,johnClass)  //Person.apply(maryClass,johnClass)

  //Scala applications = Scala object with only method
  //def main(args: Array[String]): Unit
  // thats way we wrote extends App, because that includes the def main method
}
