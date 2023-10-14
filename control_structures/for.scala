object For_Demo {
  def main(args : Array[String]) : Unit = {
    val startP = 1
    val endP = 3
    for (i <- startP to endP) {
      print(s"${i} ")
    } // 1 2 3
    println()

    for (i <- startP until endP) {
      print(s"${i} ")
    } // 1 2
    println()

    var list = List("hello", 10, 30, "Tom")
    for (item <- list) {
      println(s"item = ${item}")
    }

    forGuard()

    nestedFor()

    val res = for (i <- 1 to 10) yield i;
    println(res)
    // Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val res1 = for (i <- 1 to 10) yield {
      if (i % 2 == 0) {
        i
      } else {
        "odd"
      }
    }
    println(res1)
    // Vector(odd, 2, odd, 4, odd, 6, odd, 8, odd, 10)
  }

  def forGuard() : Unit = {
    for (i <- 1 to 3 if i != 2) {
      print(s"${i} ")
    } // 1 3
    println()

    for (i <- 1 to 3; j = 4 - i) {
      print(s"${j} ")
    } // 3 2 1
    println()

    for {
      i <- 1 to 3
      j = 4 - i
    } {
      print(s"${j} ")
    }
  }

  def nestedFor() : Unit = {
    for (i <- 1 to 3; j <- 1 to 3) {
      println(s"i=${i}, j=${j}")
    }

    // IFF
    for (i <- 1 to 3) {
      for (j <- 1 to 3) {
        println(s"i=${i}, j=${j}")
      }
    }
  }

  def stepFor() : Unit = {
    // Range(1, 10 ,2)
    // def apply(start: Int, end: Int, step: Int): Range = new Range(
    // start, end, step)
    for (i <- Range(1, 10, 2)) {
      println(s"i = ${i}")
    }

    for (i <- 1 to 10 if i % 2 == 1) {
      println(s"i = ${i}")
    }
  }
}
