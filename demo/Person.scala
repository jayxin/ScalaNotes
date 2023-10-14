object Person {
  def main(args : Array[String]) : Unit = {
    var personList = List(
      ("xiaoming1", "男", 18),
      ("xiaohua1", "女", 20),
      ("xiaomeng", "男", 18),
      ("xiaoli1", "女", 19),
      ("xiaoming2", "男", 22),
      ("xiaoli2", "女", 17),
      ("xiaoming4", "男", 28)
    )

    // 把每个人的年龄改成之前的 3 倍
    val op0 = personList.map(el => (el._1, el._2, el._3 * 3))
    println("把每个人的年龄改成之前的 3 倍:")
    println(op0)

    // 过滤年龄小于 20 的
    val op1 = personList.filter(el => el._3 < 20)
    println("过滤年龄小于 20 的:")
    println(op1)
    println("------")

    // 过滤性别是女的
    val op2 = personList.filterNot(el => el._2 == "女")
    println("过滤性别是女的:")
    println(op2)
    println("------")

    // 计算所有人的总年龄
    val op3 = personList.reduce((x, y) => ("", "", x._3 + y._3))
    println("计算所有人的总年龄:")
    println(op3._3)
    println("------")

    // 按照年龄从小到大排序
    val op4 = personList.sortWith((x, y) => x._3 < y._3)
    println("按照年龄从小到大排序:")
    println(op4)
    println("------")

    // 按照年龄从大到小排序
    val op5 = personList.sortWith((x, y) => x._3 > y._3)
    println("按照年龄从大到小排序:")
    println(op5)
    println("------")

    // 把每个人的姓名性别年龄合成一个输出
    val op6 = personList.map(x => s"${x._1}-${x._2}-${x._3}")
    println("把每个人的姓名性别年龄合成一个输出:")
    op6.foreach(println)
    println("------")

    // 把年龄为奇数和偶数的人分开
    val op7 = personList.filter(el => el._3 % 2 == 0)
    val op8 = personList.filterNot(el => el._3 % 2 == 0)
    println("把年龄为奇数和偶数的人分开")
    println(op7)
    println(op8)
  }
}
