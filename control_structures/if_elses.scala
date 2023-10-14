import scala.io.StdIn

object If_Elses_Demo {
  def main(args : Array[String]) : Unit = {
    println("score: ")
    val score = StdIn.readDouble()
    if (score == 100) {
      println("100")
    } else if (score > 80 && score <= 99) {
      println("(80, 99]")
    } else if (score >= 60 && score <= 80) {
      println("[60, 80]")
    } else {
      println("Less than 60!")
    }
  }
}
