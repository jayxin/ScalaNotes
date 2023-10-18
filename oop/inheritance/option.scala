/*
 * Scala提供null是为了实现在JVM与其它Java库的兼容性,
 但是, 除非明确需要与Java库进行交互, 否则, Scala建议尽量避免使用这种
 可能带来 bug 的null, 而改用Option类
 * Option是一个抽象类,
 有一个具体的子类 Some 和一个对象 None,
 其中, 前者表有值的情形, 后者表示没有值
 * Option(选项)类型用来表示一个值是可选的(有值或无值)
 * 当方法不确定是否有对象返回时,
 可以让返回值类型为Option[T], 其中, T为类型参数。
 对于这类方法, 如果确实有T类型的对象需要返回,
 会将该对象包装成一个 Some 对象并返回；
 若没有值需要返回, 将返回 None
 */

// 如果一个类要能够应用于模式匹配当中, 必须将类声明为case class,
// 因为一旦被定义为case class, Scala会自动生成相应的方法,
// 包括apply方法及unapply方法
case class Book(val name : String, val price : Double)

val books = Map(
  "hadoop" -> Book("Hadoop", 35.5),
  "spark" -> Book("Spark", 55.5),
  "hbase" -> Book("Hbase", 26.0),
)

books.get("hadoop") // 返回改键所对应值的 Some 对象
//res0: Option[Book] = Some(Book(Hadoop,35.5))

books.get("hive") // 不存在, 返回 None 对象
//res1: Option[Book] = None

books.get("hadoop").get // Some 对象的 get 方法返回其包装的对象
//res2: Book = Book(Hadoop,35.5)

books.get("hive").get // None 对象的 get 方法会抛出异常
//java.util.NoSuchElementException: None.get
//at scala.None$.get(Option.scala:529)
//at scala.None$.get(Option.scala:527)
//... 34 elided

books.get("hive").getOrElse(Book("Unknown name", 0))
//res4: Book = Book(Unknown name,0.0)
