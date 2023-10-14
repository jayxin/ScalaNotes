object TestPrint {
  def main(args: Array[String]): Unit = {
    var name : String = "tom"
    var sal : Double = 1.2
    println("hello " + sal + name)
    printf("name=%s sal=%f\n", name, sal)
    println(s"name=$name sal=${sal+1}")
  }
}
