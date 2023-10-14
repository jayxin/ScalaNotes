import scala.io

object CalculateSeries {
  def cal() {
    var sum : Double = 0.0
    var q : Double = scala.io.StdIn.readDouble()
    var n : Int = 1
    while (sum < q) {
      sum += (n + 1.0) / n
      n += 1
    }
    println(sum)
  }

  def main(args : Array[String]) : Unit = {
  }
}
