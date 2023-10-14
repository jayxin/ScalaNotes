import scala.collection.mutable

/*
 * 映射(Map)：一系列键值对的容器。键是唯一的,
 但值不一定是唯一的。可以根据键来对值进行快速检索
 * Scala 的映射包含了可变的和不可变的两种版本,
 分别定义在包 scala.collection.mutable 和 scala.collection.immutable 里
 默认情况下, Scala中使用不可变的映射.
 如果想使用可变映射, 必须明确地导入 scala.collection.mutable.Map
 * 可同时使用可变与不可变 Map, 不可变的直接使用 Map, 可变的使用 mutable.Map
 */
object MapDemo {
  def main(args : Array[String]) : Unit = {
    //操作符"->"是定义二元组的简写方式, 它会返回一个包含调用者和传入参数的二元组
    val map = Map("key0" -> "val0", "key1" -> "val1")
    println(map("key1"))
    // 对于这种访问方式, 若给定的键不存在, 则会抛出异常,
    // 为此, 访问前可以先调用 contains 方法确定键是否存在
    val res = if (map.contains("key1")) map("key1") else 0
    println(res)

    mutableMap()

    traverseMap()

    mergeMap()
  }

  def mutableMap() {
    val map = mutable.Map("key0" -> "val0")
    map("key0") = "val" // 更新已有元素的值
    map("key2") = "val2" // 添加新的元素
    println(map) // Map(key0 -> val, key2 -> val2)

    map += ("key1" -> "val1") // 添加一个新元素
    println(map)
    // Map(key0 -> val, key2 -> val2, key1 -> val1)
    map += ("key7" -> "val7", "key8" -> "val8") // 添加两个新元素
    println(map)
    // Map(key0 -> val, key8 -> val8, key2 -> val2, key7 -> val7, key1 -> val1)
  }

  def traverseMap() {
    val map = Map("key0" -> "val0", "key1" -> "val1")
    for ((k, v) <- map)
      println(f"${k} : ${v}")

      for (k <- map.keys)
        println(k)
        // or
        map.keys.foreach(println)

        for (v <- map.values)
          println(v)
          // or
          map.values.foreach(println)
  }

  def mergeMap() {
    val colors1 = Map(
      "red" -> "#FF0000",
      "azure" -> "#F0FFFF",
      "peru" -> "#CD853F"
    )
    val colors2 = Map(
      "blue" -> "#0033FF",
      "yellow" -> "#FFFF00",
      "red" -> "#FF0001"
    )

    //  ++ 作为运算符
    var colors = colors1 ++ colors2
    println( "colors1 ++ colors2 : " + colors )

    //  ++ 作为方法
    colors = colors1.++(colors2)
    println( "colors1.++(colors2) : " + colors )
    // 若 Map 中存在相同的 key, 合并后的 Map 中的 value 会被最右边的 Map 的值所代替
  }
}
