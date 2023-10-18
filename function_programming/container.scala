/** 针对容器的操作
 * 遍历
 * 映射
 * 过滤
 * 规约
 * 所有容器的根为Traverable特质，表示可遍历的，
 它为所有的容器类定义了抽象的 foreach 方法
 */

// foreach
// def foreach[U](f : Elem => U) : Unit
val list = List(1, 2, 3)
val f = (i : Int) => println(i)
list.foreach(f)
list.foreach(i => println(i))
list foreach println

val colors = Map(
  "red" -> "#FF0000",
  "azure" -> "#F0FFFF",
  "peru" -> "#CD853F"
)
colors.foreach{kv => println(kv._1 + ":" + kv._2)}
colors foreach {kv => println(kv._1 + ":" + kv._2)}
colors.foreach{ x => x match { case (k, v) => println(k + ":" + v) } }
colors foreach { x => x match { case (k, v) => println(k + ":" + v) } }
colors foreach { case (k, v) => println(k + ":" + v) }

// map
/*
 * 映射是指通过对容器中的元素进行某些运算来生成一个新的容器。
 两个典型的映射操作是 map 方法和 flatMap 方法
 * map方法（一对一映射）：将某个函数应用到集合中的每个元素，
 映射得到一个新的元素，map方法会返回一个与原容器类型大小都相同的新容器，
 只不过元素的类型可能不同
 * flatMap方法（一对多映射）：将某个函数应用到容器中的元素时，
 对每个元素都会返回一个容器（而不是一个元素），
 然后，flatMap把生成的多个容器“拍扁”成为一个容器并返回。
 返回的容器与原容器类型相同，但大小可能不同，
 其中元素的类型也可能不同
 */
val books = List("Hadoop", "Hive", "HDFS")
books.map(s => s.toUpperCase)
books.map(s => s.length)
books.flatMap(s => s.toList)

/** 过滤操作
 * 过滤：遍历一个容器，从中获取满足指定条件的元素，返回一个新的容器
 * filter方法：接受一个返回布尔值的函数f作为参数，并将f作用到每个元素上，
 将f返回真值的元素组成一个新容器返回
 */
List(1, 2, 3, 4, 5, 6) filter { _ % 2 == 0 }
List(1, 2, 3, 4, 5, 6).filter(_ % 2 == 0)

/** 规约操作
 * 规约操作是对容器元素进行两两运算，将其 “规约” 为一个值
 * reduce方法：接受一个二元函数f作为参数，
 首先将f作用在某两个元素上并返回一个值，
 然后再将f作用在上一个返回值和容器的下一个元素上，
 再返回一个值，依此类推，最后容器中的所有值会被规约为一个值
 * fold方法：一个双参数列表的函数，从提供的初始值开始规约。
 第一个参数接受一个规约的初始值，第二个参数接受与reduce中一样的二元函数参数
 * foldLeft和foldRight：前者从左到右进行遍历，后者从右到左进行遍历
 */
val list = List(1, 2, 3, 4, 5)
list.reduce(_ + _)
list.reduce(_ * _)
list map (_.toString) reduce ((x, y) => s"f($x, $y)")

// reduceLeft和reduceRight：
// 前者从左到右进行遍历，后者从右到左进行遍历
list reduceLeft {_ - _} // -13
list reduceRight {_ - _} // 3
val s = list map (_.toString)
s reduceLeft { (accu, x) => s"($accu-$x)" } // list reduceLeft {_ - _} 计算过程
//((((1-2)-3)-4)-5)
s reduceRight { (x, accu) => s"($x-$accu)" } // list reduceRight {_ - _} 计算过程
//(1-(2-(3-(4-5))))

list.fold(10)(_ * _) // 1200
(list fold 10)(_ * _) // 1200
(list foldLeft 10)(_ - _) // -5
(list foldRight 10)(_ - _) // -7
