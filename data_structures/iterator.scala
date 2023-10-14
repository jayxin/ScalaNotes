/*
 * 迭代器(Iterator)不是一个容器, 而是提供了按顺序访问容器元素的数据结构
 * 迭代器包含两个基本操作: next 和 hasNext.
 next 可以返回迭代器的下一个元素, hasNext 用于检测是否还有下一个元素
 * 尽管构造一个迭代器与构造一个容器很类似, 但迭代器并不是一个容器类,
 因为不能随机访问迭代器的元素, 而只能按从前往后的顺序依次访问其元素
 * 实际上, 迭代器的大部分方法都会改变迭代器的状态,
 例如, 调用 length 方法会返回迭代器元素的个数,
 但是, 调用结束后, 迭代器已经没有元素了, 再次进行相关操作会报错
 * 建议除next和hasnext方法外, 在对一个迭代器调用了某个方法后,
 不要再次使用该迭代器
 */
object IteratorDemo {
  def main(args : Array[String]) : Unit = {
    val iter = Iterator("Hadoop", "Spark", "Scala")
    while (iter.hasNext) {
      println(iter.next())
    }

    for (el <- iter) {
      println(el)
    }

    max()
    min()

    getLength()
  }

  def max() {
    val iter = Iterator(20, 40, 2, 50, 69, 90)
    println(iter.max) // 90
  }

  def min() {
    val iter = Iterator(20, 40, 2, 50, 69, 90)
    println(iter.min) // 2
  }

  def getLength() {
    val iter_a = Iterator(20, 40, 2, 50, 69, 90)
    val iter_b = Iterator(20, 40, 2, 50, 69, 90)
    println(iter_a.size) // 6
    println(iter_b.length) // 6
  }
}
