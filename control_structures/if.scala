import scala.io.StdIn
import scala.io._ // import all packages

object If_Demo {
  def main(args : Array[String]) : Unit = {
    println("age:")
    val age = StdIn.readInt()
    if (age > 18) {
      println("age > 18")
    }
  }
}
