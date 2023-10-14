object SetDemo {
  def main(args : Array[String]) : Unit = {
    /*
     * 集合(set)：不重复元素的容器（collection）
     * 列表（List）中的元素是按照插入的先后顺序来组织的, 但是,
     集合中的元素并不会记录元素的插入顺序, 而是以哈希方法对元素的值进行组织,
     所以, 它允许你快速地找到某个元素
     * 集合包括可变集和不可变集, 分别位于scala.collection.mutable
     包和 scala.collection.immutable 包, 缺省情况下创建的是不可变集
     * 如果要声明一个可变集, 则需要提前引入 scala.collection.mutable.Set
     import scala.collection.mutable.Set
     val myMutableSet = Set("Database", "BigData")
     myMutableSet += "Cloud Computing"
     * 虽然可变集和不可变集都有添加或删除元素的操作,
     但是, 二者有很大的区别. 对不可变集进行操作, 会产生一个新的集,
     原来的集并不会发生变化. 而对可变集进行操作, 改变的是该集本身
     * 集合有 3 个基本操作:
     - head 返回集合第一个元素
     - tail 返回一个集合, 包含除了第一个元素之外的其他元素
     - isEmpty 在集合为空时返回 true
     */
    var mySet = Set("Hadoop", "Spark")
    mySet += "Scala" // 若使用 val, 这里会报错
    mySet.foreach(println(_))
    // Hadoop
    // Spark
    // Scala

    val site = Set("Microsoft", "Google", "Baidu")
    val nums : Set[Int] = Set()
    println("第一个网站是: " + site.head)
    // 第一个网站是: Microsoft
    println("最后一个网站是: " + site.tail)
    // 最后一个网站是: Set(Google, Baidu)
    println("查看 site 是否为空: " + site.isEmpty)
    // 查看 site 是否为空: false
    println("查看 nums 是否为空: " + nums.isEmpty)
    // 查看 nums 是否为空: true

    concatenate()

    intersect()
  }

  def concatenate() {
    val site1 = Set("Runoob", "Google", "Baidu")
    val site2 = Set("Facebook", "Taobao")
    var site = site1 ++ site2
    print("site1 ++ site2: ")
    println(site)
    //site1 ++ site2: Set(Taobao, Google, Facebook, Baidu, Runoob)

    site = site1.++(site2)
    print("site1.++(site2): ")
    println(site)
    //site1.++(site2): Set(Taobao, Google, Facebook, Baidu, Runoob)
  }

  def intersect() {
    val num1 = Set(5, 6, 9, 20, 30, 45)
    val num2 = Set(50, 60, 9, 20, 35, 55)

    println("num1.&(num2): " + num1.&(num2))
    //num1.&(num2): Set(20, 9)
    println("num1.intersect(num2): " + num1.intersect(num2))
    //num1.intersect(num2): Set(20, 9)
  }
}
