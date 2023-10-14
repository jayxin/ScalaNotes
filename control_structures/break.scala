import util.control.Breaks._

object BreakDemo {
  def main(args : Array[String]) : Unit = {
    var n = 1


    /*def breakable(op: => Unit) {
      try {
        op
      } catch {
        case ex: BreakControl =>
          if (ex ne breakException) throw ex
      }
    }*/

    breakable {
      while (n <= 20) {
        n += 1
        println(s"n=${n}")
        if (n == 18) {
          // def break() : Nothing = { throw breakException }
          break()
        }
      }
    }

    val arr = Array(1, 3, 10, 5, 4)
    breakable {
      for (i <- arr) {
        if (i > 5) break // 跳出 breakable, 终止 for 循环, 相当于 Java 中的 break
        println(i)
      }
    } // 1 3

    for (i <- arr) {
      breakable {
        if (i > 5) break // 跳出 breakable, 终止当次循环, 相当于 Java 中的 continue
        println(i)
      }
    } // 1 3 5 4
  }
}
