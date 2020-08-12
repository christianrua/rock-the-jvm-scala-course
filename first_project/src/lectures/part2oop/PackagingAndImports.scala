package lectures.part2oop

import javax.swing.JSpinner.DateEditor
import playground.{PrinceCharming, ScalaPlayGround}

// you can use ._ to call of the content of the package, only used when is really needed
//aliasing import playground.{PrinceCharming, ScalaPlayGround => theNameYouWant}, is important to say
//that this practice is use full when call different packages from different modules, but whit the
//same name.

//Example of the above:
import java.util.Date
import java.sql.{Date => SqlDate}


object PackagingAndImports extends App{

  // a Package is a bunch of definitions group under the same name

  //package members are accessible by their simple name. the class Writer is located in OOBasics file
  val writer = new Writer("Daniel","RockTheJVM", 2018)

  //import the package
  val playground = ScalaPlayGround // val playground = playground.ScalaPlayGround == fully qualified name

  //packages are high order hierarchy
  //matching folder structure on file system

//package object are universal constans or methods outside everything else
//can be only one per package

  sayHello
  println(SPEED_OF_LIGHT)

//imports
val prince = PrinceCharming

//using aliasing

val date = new Date()
val sqlDate = new SqlDate(2020,8,12)

//default imports
  //java.lang - String, Object, Exception
  //Scala - Int, Nothing, Function
  //scala.Predef - println, ???

}
