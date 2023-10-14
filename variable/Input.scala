import scala.io.StdIn
import scala.io.Source
import java.io.PrintWriter

object Input {
  /** 控制台输入输出语句
   * readInt
   * readDouble
   * readByte
   * readShort
   * readFloat
   * readLong
   * readChar
   * readBoolean
   * readLine(可以不提供参数, 也可以带一个字符串参数的提示)

   * print()
   * printf()
   * println()
   * print(), printf(), println() 都在对象 Predef 中定义,
该对象默认情况下被所有 Scala 程序引用, 因此可直接使用 Predef
对象提供的方法, 无需使用 scala.Predef. 的形式
   */
  def main(args : Array[String]) : Unit = {
    val name = StdIn.readLine("name: ")
    println("age:")
    val age = StdIn.readInt()
    println("salary:")
    val sal = StdIn.readDouble()
    printf("name = %s, age = %d, sal = %.2f\n", name, age, sal)

    Cat.sayHi()
    Cat.sayHello()

    val i = 10
    val f = 3.5
    val s = "hello"
    println(s"$s:i=$i,$f")
    println(f"$s:i=$i%-4d,f=$f%.1f")

    writeFile()
    readFile()
  }

  def readFile() {
    val inputFile = Source.fromFile("test.txt")
    val lines = inputFile.getLines // 返回迭代器
    for (line <- lines)
      println(line)
  }

  def writeFile() {
    val outputFile = new PrintWriter("test.txt")
    outputFile.println("Hello World")
    outputFile.print("Spark is good")
    outputFile.close()
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
