import scala.io.StdIn

object Input {
  def main(args : Array[String]) : Unit = {
    println("name:")
    val name = StdIn.readLine()
    println("age:")
    val age = StdIn.readInt()
    println("salary:")
    val sal = StdIn.readDouble()
    printf("name = %s, age = %d, sal = %.2f\n", name, age, sal)

    Cat.sayHi()
    Cat.sayHello()
  }
}

object Cat extends AAA {
  def sayHi() : Unit = {
    println("hello")
  }
}

trait AAA { // iff interface+abstract class in Java
  def sayHello() : Unit = {
    println("In AAA")
  }
}
