package lectures.part2oop

object AbstractDataTypes extends App{

  //abstract
  abstract class Animal {
    val creatureType: String = "Wild"
    def eat : Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  //traits
  trait Carnivore {
    def eat(animal : Animal): Unit
    val preferredMeal : String = "fresh meat"
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Croc"
    def eat: Unit = "nomnomnom"
    def eat(animal: Animal): Unit = println(s"i'm a croc and i àm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  /*differences between traits and abstract classes
  abstract classes can have have abstract and non abstract members. abstract means not implemented.
  this is also true for traits.
  so the main difference is:
  1. trait do not have constructor parameters
  2. multiple traits may be inherited by the same class
  3. we choose a trait vs a abstract class if it describes a type of behavior.
  traits = behavior
  abstract class = type of "thing"
  */


}
