/* 模式匹配 match 语句
 * 最常见的模式匹配是 match 语句, 用在当需要从多个分支中进行选择的场景,
 * 一个模式匹配包含了一系列备选项, 每个都开始于关键字 case。
 * 每个备选项包含一个模式及一到多个表达式, => 隔开模式和表达式
 * 通配符_相当于Java中的default分支
 * match 结构中不需要 break 语句来跳出判断,
 Scala从前往后匹配到一个分支后, 会自动跳出判断
 * case 后面的表达式可以是任何类型的常量, 而不要求是整数类型
 */
import scala.io.StdIn._


object MatchDemo {
  def main(args : Array[String]) : Unit = {
    println("Please input the score:")

    val grade = readChar()

    grade match {
      case 'A' => println("85-100")
      case 'B' => println("70-84")
      case 'C' => println("60-69")
      case 'D' => println("<60")
      case _ => println("error input!")
    }

    // 除了匹配特定的常量, 还能匹配某种类型的所有值
    for (elem <- List(6, 9, 0.618, "Spark", "Hadoop", "Hello")) {
      val str  = elem match {
        case i : Int => i + " is an int value." // 匹配整型的值, 并赋值给i
        case d : Double => d + " is a double value." // 匹配浮点型的值
        case "Spark" => "Spark is found." // 匹配特定的字符串
        case s : String => s + " is a string value." // 匹配其它字符串
        case _ => "unexpected value：" + elem  // 与以上都不匹配
      }
      println(str)
    }

    // 可以在 match 表达式的 case 中使用守卫式（guard）添加一些过滤逻辑
    for (elem <- List(1, 2, 3, 4)){
      elem match {
        case _ if (elem % 2 == 0) => println(elem + " is even.")
        case _ => println(elem + " is odd.")
      }
    }
  }
}
