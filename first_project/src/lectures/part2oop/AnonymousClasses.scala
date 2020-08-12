package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  //anonymous class
  val funnyAnimal: Animal = new Animal{
    override def eat : Unit = println("ahahahahahahaha")
  }
  /*
  equivalent with
  class AnonymousClasses$$anon$1 extends Animal {
  override def eat: Unit = println("hahahahahahahaha")}

  val funnyAnimal: Animal = new AnonymousClasess$$anon$1
   */

  println(funnyAnimal.getClass)

  class Person (name:String){
    def sayHi:Unit = println(s"Hi, mu name is $name, how can i help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service")
  }

  /*
  1. Generic trait MyPredicate[-T] have a small method test(T) => Boolean, to test where a value
  of type T passes the condition
  2. Generic trait MyTransformer[-A,B] have a method to convert a value of type A to type B
  with a method call transform(A) => B
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

}
