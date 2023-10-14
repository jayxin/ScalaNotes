/*
 * 元组是对多个不同类型对象的一种简单封装.
 定义元组最简单的方法就是把多个元素用逗号分开并用圆括号包围起来。
 使用 下划线"_"加上从1开始的索引值, 来访问元组的元素
 * 若需在方法里返回多个不同类型的对象, Scala 可以通过返回一个元组来实现
*/
object TupleDemo {
  def main(args : Array[String]) : Unit = {
    val tuple = ("BigData", 2023, 123.45)
    println(tuple)
    println(tuple._1)
    println(tuple._2)
    println(tuple._3)
  }
}
