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
  }
}
