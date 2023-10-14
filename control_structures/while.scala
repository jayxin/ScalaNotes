object WhileDemo {
  def main(args : Array[String]) : Unit = {
    var i = 0
    while (i < 10) {
      println(i)
      i += 1
    }

    i = 0
    do {
      println(i)
      i += 1
    } while (i < 5)
  }
}
