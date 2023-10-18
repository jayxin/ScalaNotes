/*
 * 类的定义
 * 类成员的可见性
 * 方法的定义方式
 * 构造器

 * Scala 类中所有成员的默认可见性为公有, 任何作用域内都能直接访问公有成员
 * 除了默认的公有可见性, Scala 也提供private和protected,
 其中, private成员只对本类型和嵌套类型可见;
 protected成员对本类型和其继承类型都可见
 * 为了避免直接暴露public字段,
 建议将字段设置为private, 对于 private 字段,
 Scala 采用类似 Java 中的 getter 和 setter 方法,
 定义了两个成对的方法 value 和 value_= 进行读取和修改
 */

class Counter {
  // 这里定义类的字段和方法
  // 字段定义:字段用 val 或 var 进行定义

  // 方法定义: def 方法名(参数列表) : 返回结果类型 = { 方法体  }
  /*
   * 方法参数前不能加上val或var, 所有的方法参数都是不可变类型
   * 无参数的方法定义时可以省略括号, 这时调用时也不能带有括号;
   若定义时带有括号, 则调用时可以带括号, 也可以不带括号
   * 方法名后面的圆括号()可用花括号{}来代替
   * 若方法只有一个参数, 可省略点号(.)而采用中缀操作符调用方法
   * 若方法体只有一条语句, 可以省略方法体两边的大括号
   * 当方法的返回结果类型可以从最后的表达式推断出时, 可以省略结果类型
   * 如果方法返回类型为Unit, 可以同时省略返回结果类型和等号, 但不能省略大括号
   */

  var value = 0

  // Unit 相当于 Java 中的 void
  def increment(step : Int) : Unit = { value += step }
  //def increment(step : Int) : Unit = value += step
  //def increment(step : Int) { value += step } // 赋值语句的值为 Unit 类型

  // 方法的返回值不需要靠 return 语句
  // 方法中的最后一个表达式的值就是方法的返回值
  // 若花括号中只有一行语句, 则也可省略花括号
  //def current() : Int = { value }
  def current : Int = value
  //def current() = value // 根据 value 的类型自动推断出返回类型为 Int 型

  def getValue() : Int = value
}

// Scala类的定义主体就是类的构造器, 称为主构造器。
// 在类名之后用圆括号列出主构造器的参数列表
// 主构造器的参数前可以使用val或var关键字,
// Scala内部将自动为这些参数创建私有字段, 并提供对应的访问方法
// 若不希望将构造器参数成为类的字段, 只需省略关键字 var 或 val
// Scala 类可以包含零个或多个辅助构造器(auxiliary constructor),
// 辅助构造器使用 this 进行定义，this 的返回类型为 Unit
// 每个辅助构造器的第一个表达式必须是调用一个此前已经定义的辅助构造器或主构造器,
// 调用的形式为 this(参数列表)
class Counter1(var name : String, val mode : Int) {
  private var value = 0
  def increment(step : Int) : Unit = { value += step }
  def current() : Int = { value }
  def info() : Unit = { printf("%s %d", name, mode) }
}

class Counter2 {
  private var value = 0
  private var name = ""
  private var step = 1
  println("the main constructor")
  def this(name : String) { // 第一个辅助构造器
    this() // 调用主构造器
    this.name = name
    printf("The first auxiliary constructor, name: %s\n", name)
  }

  def this(name : String, step : Int) { // 第二个辅助构造器
    this(name) // 调用前一个辅助构造器
    this.step = step
    printf(
      "The second auxiliary constructor, name: %s, step: %d\n",
      name, step
    )
  }
  def increment(step : Int) : Unit = { value += step }
  def current() : Int = { value }
}

object ClassDemo {
  def main(args : Array[String]) : Unit = {
    val myCounter = new Counter
    //val myCounter = new Counter()
    myCounter.value = 5 // 访问字段
    myCounter.increment(3)
    // 调用无参数方法时, 可省略括号
    println(myCounter.current) // 8

    val c = new Counter
    c increment 5 // 中缀调用
    println(c.getValue())
    println(c.getValue)
    //println(c.current()) // current 定义中没有括号, 不可带括号调用
    println(c.current)

    var counter = new Counter1("Runner", 2)
    println(counter.name)
    counter.name_=("Timer")
    counter.name = "Timer"
    counter.info
    counter.increment(1)
    println(counter.current)

    val c1 = new Counter2
    val c2 = new Counter2("the 2nd Counter")
    val c3 = new Counter2("the 3rd Counter", 2)
  }
}
