package lectures.part1basics

object DefaultArtgs extends App {

  def trFactorial(n:Int, acc:Int = 1):Int = //you can leave the as default value of acc
    if (n >= 1) acc
    else trFactorial(n-1, n*acc)

  val fact10 = trFactorial(10, 2) // or you can override it with another value

  def savePicture(format: String, width: Int, heigth: Int): Unit = println("saving picture")
  savePicture("jpg", 800, 600)

  /*
  if you want to set default values, and later on override it, you must write the name or the argument
  and the value, like in python
   */
}
