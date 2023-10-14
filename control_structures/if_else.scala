import scala.io.StdIn

object If_Else_Demo {
  def main(args : Array[String]) : Unit = {
    println("age:")
    val age = StdIn.readInt()
    if (age > 18) {
      println("age > 18")
    } else {
      println("age <= 18")
    }
    println(judge(2018))
  }

  def judge(year : Int) : Boolean = {
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
      return true;
    } else {
      return false;
    }
  }
}
