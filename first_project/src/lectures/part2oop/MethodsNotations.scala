package lectures.part2oop
import scala.language.postfixOps

object MethodsNotations extends App {

  class Person (val name:String, favoriteMovie:String, val age:Int = 0) {
    def likes(movie:String):Boolean = movie == favoriteMovie
    def hangOutwith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and i like $favoriteMovie"
    //def +(nickname: String):String = s"${this.name} (the $nickname)"
    def +(nickname: String):Person = new Person(s"$name ($nickname)",favoriteMovie)
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)
    def learns(topic:String):String = s"${this.name} learns $topic"
    def learnsScala:String = this.learns("Scala") // is the same as this learns "Scala"
    def apply(n:Int):String = s"${this.name} watched ${this.favoriteMovie} $n times"
  }

  val mary = new Person("Mary","Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") //equivalent, this is call infix notation = operator notation. (syntactic sugar)
  //only works with methods with 1 parameter

  //"operators" in Scala
  val tom = new Person("Tom", "Fight club")
  println(mary hangOutwith tom)

  println(1 + 2)
  println(1.+(2))

  //ALL OPERATORS ARE METHODS.

  //prefix notation
  val x = -1 //equivalent with 1.unary_-
  val y = 1.unary_-
  //unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply

  println(mary.apply())
  println(mary()) //equivalent as above

  /*
  1. overload the + operator receives String and return the name with nick name
    example mary +"the rockstar" => new person "Mary (the rockstar)"
  */
  //println(mary + "rockstar")
  println((mary + "the rockstar")()) // is the same that println((mary + "the rockstar").apply())


  /*
  2. Add an age to person class with default zero value
    add a unary + operator => mary with the age incrementer
    +mary => mary with the age incrementer
   */
  val newMary = mary.unary_+
  println(newMary.age)

  //is the same that as above
  println((+mary).age)

  /*
   3. add a "learns" method in the person class => "Mary learns Scala"
    add a learnsScala method, call learns method with "Scala" as parameter
    use it in postfix notation.
  */
  println(mary learnsScala)
  /*
   4. Overload the apply method
   mary.apply(2) => "Mary watched inception 2 times"
   */
  println(mary.apply(3)) //is the same as println(mary(10))
}
