package lectures.part2oop

object Inheritence extends App {

  // single class inheritance
  //final class {     // prevents that the entire class to be extended
  class Animal {
    //private def eat = println("nomnom") //is for only use of the class Animal
    val creatureType = "wild"
    //protected def eat = println("nomnom") //is for use of the super class and subclasses
    def eat = println("nomnom")
    //final def eat = println("nomnom")  //prevents that derived classes overrides this method
  }

  //inherits only non private functions and vals
  class Cat extends Animal {
    def crunch = {
      eat //is only accesible inside the subclass
      println("crunch crunch")
    }
  }

  val cat = new Cat
  // cat.eat this is not accesible
  cat.crunch

  //constructors
  class Person(nae:String, age:Int){
    def this(name:String) = this(name,0) //auxiliary constructor
  }
  class Adult(name:String, age:Int,idCard:String) extends Person (name, age) // the correct way of extenders a super class with parameters

//overriding

  //class Dog extends Animal {
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType: String = "domestic"
    //override def eat = println("crunch crunch")
    override def eat = {
      super.eat //it refers to the implementation in the parent class
      println("crunch crunch")
    }
  }
//same as above
// class Dog(dogType: String) extends Animal {
//  override val creatureType: String = dogType
//  }
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  //overRIDING vs overLOADING
  //overRIDING means supply different implementation in derive classes
  //overLOADING means supply multiples methods with different signatures o with the same name
  //in the same class

  // super. is used when you want to reference a method or a field from a parent class

  // preventing overrides
  // 1 - use the key word final on member or method
  // 2 - use the key word final on a class, it prevents the entire class to be extended
  // 3 - use the key word seal, to seal the class: this means a soft restriction that
  // you can extend that class in this file, and prevent extension in other files
}
