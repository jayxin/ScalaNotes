import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException


/*
 * Scala 的异常处理和 Java 类似, Scala 的方法可以通过抛出异常的方式来终止
 相关代码的运行。Scala 不支持 Java 中的"受检查异常"(checked exception),
 将所有异常都当作"不受检异常"(或称运行时异常 Runtime Exception),
 Scala仍使用 try-catch 结构来捕获异常,
 在 Scala 里, 借用了模式匹配的思想来做异常的匹配,
 因此, 在 catch 的代码里, 是一系列 case 子句.
 受检异常的特点在于它强制要求开发人员在代码中进行显式的声明和捕获,
 否则就会产生编译错误. 而非受检异常的特点是,
 如果不捕获异常, 不会产生编译错误, 异常会在运行时刻才被抛出非受检异常,
 好处是可以去掉一些不需要的异常处理代码, 而不好之处是开发人员可能忽略某些应处理的异常
 https://www.cnblogs.com/tjudzj/p/7053980.html
 */
object ExcpetionDemo {
  def main(args : Array[String]) : Unit = {
    try {
      val f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException =>
        println("Missing file exception")
      case ex: IOException =>
        println("Missing file exception")
    } finally {
        file.close()
        println("Exiting finally...")
    }
  }
}
