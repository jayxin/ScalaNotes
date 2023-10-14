/**
 * Scala 提供了一套丰富的容器(collection)库,
 包括序列 Sequence、集合 Set、映射 Map 等
 * Scala用了三个包来组织容器类，分别是
 scala.collection 、scala.collection.mutable 和 scala.collection.immutable
 * scala.collection 封装了可变容器和不可变容器的超类或特质,
 定义了可变容器和不可变容器的一些通用操作
 * scala.collection 包中容器的宏观层次结构:
  - Traversable
    + Iterable
      - Seq
        + IndexedSeq
        + LinearSeq
      - Set
        + SortedSet
        + BitSet
      - Map
        + SortedMap
 */
object CollectionDemo {
  def main(args : Array[String]) : Unit = {
  }
}

/*
 * 所有容器的根为 Traverable 特质, 表示可遍历的, 它为所有的容器类定义了抽象的 foreach 方法,
 该方法用于对容器元素进行遍历操作
 * Iterable 特质, 表示元素可一个个地依次迭代, 该特质定义了一个抽象的
 iterator 方法, 混入该特质的容器必须实现 iterator 方法, 返回一个迭代器 Iterator
 * Iterable 特质还给出了其从 Traverable 继承的 foreach 方法的一个默认实现,
 即通过迭代器进行遍历
 */
