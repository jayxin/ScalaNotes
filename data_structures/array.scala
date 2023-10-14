/*
数组: 一种可变的、可索引的、元素具有相同类型的数据集合

Scala 提供了参数化类型的通用数组类 Array[T],
其中 T 可以是任意的 Scala 类型, 可通过显式指定类型
或通过隐式推断来实例化一个数组
*/
object ArrayDemo {
  def main(args : Array[String]) : Unit = {
    val intValueArr = new Array[Int](3) // 长度为 3, 每个元素初始化为 0
    intValueArr(0) = 12
    intValueArr(1) = 45
    intValueArr(2) = 33
    println(intValueArr)

    val strArr = new Array[String](3) // 长度为 3, 每个元素初始化为 null
    strArr(0) = "BigData"
    strArr(1) = "Hadoop"
    strArr(2) = "Spark"
    for (i <- 0 to 2) println(strArr(i))

    //val intValueArr = Array(12, 45, 33)  // type inference
    //val strArr = Array("BigData", "Hadoop", "Spark")  // type inference

    // 多维数组的创建
    val myMatrix = Array.ofDim[Int](3, 4) // 类型是 Array[Array[Int]]
    val myCube = Array.ofDim[String](3, 2, 4) // 类型是 Array[Array[Array[String]]]
    // myMatrix(0)(1) 返回第一行第二列的元素

    val a = new Array[Array[Int]](2)
    a(0) = new Array[Int](3)
    a(1) = new Array[Int](3)
    println(a)
  }
}
