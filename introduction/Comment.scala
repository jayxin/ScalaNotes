object Comment {
  def main(args: Array[String]): Unit = {
    println("hello, world!")
  }

  /**
    * @deprecated
    * @example
    *   n1 == 10, n2 == 20, return 30
    * @param n1
    * @param n2
    * @return summation
   */
  def sum(n1 : Int, n2 : Int) : Int = {
    return n1 + n2
  }
}
