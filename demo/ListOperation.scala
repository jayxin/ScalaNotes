object ListOperation {
  def main(args : Array[String]) : Unit = {
    // 创建一个名为 list 的 List列表
    val list = List(
      6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1, 2, 3, 4, 5
    )
    println("创建一个名为 list 的 List列表:")
    println(list)
    println("------")

    // 使用 map 方法和 foreach 方法 list 遍历
    println("使用 map 方法和 foreach 方法 list 遍历:")
    list.map(el => s"${el} ").foreach(print)
    println()
    println("------")

    // 将集合内数据 +10 产生一个新的列表 L2
    val L2 = list.map(el => el + 10)
    println("将集合内数据 +10 产生一个新的列表 L2:")
    println(L2)
    println("------")

    // 将 L2 中的所有偶数取出来产生一个新的列表 L3
    val L3 = L2.filter(el => el % 2 == 0)
    println("将 L2 中的所有偶数取出来产生一个新的列表 L3:")
    println(L3)
    println("------")

    // 计算 L3 数据的总和
    val res = L3.reduce((x, y) => x + y)
    println("计算 L3 数据的总和:")
    println(res)
    println("------")

    // 将 L3 倒序排序
    val L4 = L3.sortWith((x, y) => x > y)
    println("将 L3 倒序排序:")
    println(L4)
    println("------")

    // 将 L3 反转
    val L5 = L3.reverse
    println("将 L3 反转:")
    println(L5)
    println("------")

    // 创建新 list1 数据为 List(Array(11,22,33), Array(44,55,66))
    val list1 = List(
      Array(11, 22, 33),
      Array(44, 55, 66)
    )
    println("创建新 list1 数据为 List(Array(11,22,33), Array(44,55,66)):")
    println(list1)
    println("------")

    // 使用 flatten 将 list1 列表合并成一个新的列表
    val L1 = list1.flatMap(x => x.toList)
    println("使用 flatten 将 list1 列表合并成一个新的列表:")
    println(L1)
    println("------")

    // 将 list 奇数偶数分开打印
    println("将 list 奇数偶数分开打印:")
    list.filterNot(
      el => el % 2 == 0
    ).foreach(
      el => print(s"${el} ")
    )
    println()
    list.filter(
      el => el % 2 == 0
    ).foreach(
      el => print(s"${el} ")
    )
    println()
  }
}
