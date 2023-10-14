/*
 * 序列(Sequence): 元素可以按照特定的顺序访问的容器.
 序列中每个元素均带有一个从0开始计数的固定索引位置
 * 序列容器的根是 collection.Seq 特质.
 其具有两个子特质 LinearSeq 和 IndexedSeq.
 LinearSeq 序列具有高效的 head 和 tail 操作, 而 IndexedSeq 序列具有
 高效的随机存储操作
 * 实现了特质 LinearSeq 的常用序列有列表 List 和队列 Queue.
 实现了特质 IndexedSeq 的常用序列有可变数组 ArrayBuffer 和向量 Vector
 */

object SequenceDemo {
  def main(args : Array[String]) : Unit = {
    /*
     * 列表: 一种共享相同类型的不可变的对象序列,
     定义在 scala.collection.immutable 包中
     * 不同于 Java 的 java.util.List, scala 的 List 一旦被定义,
     其值就不能改变, 因此声明 List 时必须初始化
     * 列表有头部和尾部的概念,可分别用 head 和 tail 方法来获取
     * head 返回的是列表第一个元素的值
     * tail 返回的是除第一个元素外的其它值构成的新列表,
     这体现出列表具有递归的链表结构
     * 不能用 new 来建立 List(原型: sealed abstract class List[+A])
     * 补充相同类型:对于包括List在内的所有容器类型, 如果没有显式指定元素类型,
     Scala会自动选择所有初始值的最近公共类型来作为元素的类型。
     因为 Scala 的所有对象都来自共同的根 Any,
     因此, 原则上容器内可以容纳任意不同类型的成员。
     例如：val x = List(1, 3.4, "Spark")
     * 除了 head、tail 操作是常数时间 O(1), 其它按索引访问的操作都需要从头开始遍历,
     因此是线性时间复杂度O(N)
     */
    var strList = List("BigData", "Hadoop", "Spark")
    println(strList.head) // BigData
    println(strList.tail) // List(Hadoop, Spark)

    val otherList = "Apache" :: strList
    println(strList) // List(BigData, Hadoop, Spark)
    println(otherList) // List(Apache, BigData, Hadoop, Spark)

    // Scala 还定义了一个空列表对象Nil, 借助Nil,
    // 可以将多个元素用操作符 :: 串起来初始化一个列表
    // :: 是向右结合的(: 结尾的操作符都是向右结合)
    val intList = 1::2::3::Nil
    // IFF
    //val intList = List(1, 2, 3)

    /*
     * Vector 可以实现所有访问操作都是常数时间
     * 可以创建和高效地通过索引来访问集合中的元素
     */
    val v = Vector("a", "b", "c")
    println(v(1))

    // 不能改变一个Vector, 但是你可以给 Vector 添加一个元素,
    // 产生一个新的 Vector 然后用一个新的变量来指向这个 Vector
    val a = Vector(1, 2, 3)
    val b = a ++ Vector(4, 5)
    println(a) // Vector(1, 2, 3)
    println(b) // Vector(1, 2, 3, 4, 5)

    // 可用 update 方法替换 Vector 中的元素,
    // 生成一个新的 Vector 然后用一个新的变量来指向这个新的 Vector
    val c = a.updated(0, 4)
    println(a) // Vector(1, 2, 3)
    println(c) // Vector(4, 2, 3)

    // +: 和 :+ 是 Seq 的方法, 执行后 vector 本身没变
    val vec1 = Vector(1, 2)
    val vec2 = 3 +: 4 +: vec1
    val vec3 = vec2 :+ 5
    println(vec3(3)) // 2

    /*
     * :: 为构造, 向队列的头部追加元素, 创造新的列表.
     用法为 x::list, 其中 x 为加入到头部的元素,
     无论x是列表与否, 它都只将成为新生成列表的第一个元素
     * :+ 和 +: 两者的区别在于 :+ 方法用于在尾部追加元素,
     +: 方法用于在头部追加元素
     * ++ 用于连接两个集合
     * ::: 用于连接两个List类型的集合
     * 以冒号结尾的中缀操作符的调用对象在右侧,
     所以这些操作符是从右往左结合的.
     例如, "a + b + c + d"的结合顺序是"((a + b) + c) + d",
     而"a ::: b ::: c ::: d"的结合顺序则是"a ::: (b ::: (c ::: d))"
     * 中缀操作符的左右两边都接收操作数, 它对应普通的有参方法.
     两个操作数中的一个是调用该方法的对象, 一个是传入该方法的参数
     */
    val mi2 = new MyInt2(10)
    println(mi2 +* 10) // 200
    //println(mi2 +: 10) // error: value +: is not a member of Int
    println(10 +: mi2) // 20
    operatorUsage()

    /*
     * Range 类: 一种特殊的、带索引的不可变数字等差序列.
     其包含的值为从给定起点按一定步长增长(减小)到指定终点的所有数值
     * Range 可以支持创建不同数据类型的数值序列,
     包括 Int、Long、Float、Double、Char、BigInt 和 BigDecimal 等
     */
    val r = Range(1, 5, 1)
    println(r)  // Range 1 until 5
    println(1 until 5) // Range 1 until 5
    println(1 to 5) // Range 1 to 5
    println(1.to(5)) // Range 1 to 5
    println(1 to 10 by 2) // inexact Range 1 to 10 by 2
    println(1.to(10).by(2)) // inexact Range 1 to 10 by 2
    //println(0.5f to 5.9f by 0.8f)
  }

  def operatorUsage() {
    val a : List[String] = List("2" ,"3")
    println(1::a) // List(1, 2, 3)
    val b : List[String] = List("a" ,"b")
    println(b::a) // List(List(a, b), 2, 3)
    println("A"::"B"::Nil) // List(A, B)
    println("A"+:"B") // Vector(A, B)
    println("A"+:"B"::Nil) // List(Vector(A, B))
    println("A"+:"B"+:Nil) // List(A, B)
    println(Nil:+"A":+"B") // List(A, B)
  }
}

class MyInt2(val x : Int) {
  def +*(y : Int) = (x + y) * y
  def +:(y : Int) = x + y
}
