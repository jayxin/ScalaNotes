/** trait
 * Java 中提供了接口, 允许一个类实现任意数量的接口
 * Scala 中没有接口的概念, 而是提供了特质(traits), 它不仅实现了接口的功能,
 还具备了很多其他的特性
 * Scala 的特质是代码重用的基本单元, 可以同时拥有抽象方法和具体方法
 * Scala 中, 一个类只能继承自一个超类, 却可以实现多个特质,
 从而重用特质中的方法和字段, 实现了多重继承
 */

trait Flyable {
  var maxFlyHeight : Int // 抽象字段

  def fly() // 抽象方法, 包含抽象成员时不需要 abstract 关键字

  def breathe() { // 具体方法
    println("I can breathe")
  }
}
// 特质可以使用 extends 继承其他的特质

/* 把特质混入类中
 * 可以使用 extends 或 with 关键字把特质混入类中
 * 如果特质中包含抽象成员，则该类必须为这些抽象成员提供具体实现，
 除非该类被定义为抽象类
 */
class Bird(flyHeight : Int) extends Flyable {
  var maxFlyHeight : Int = flyHeight // 重载特质的抽象字段
  def fly() {
    printf("I can fly at the height of %d.\n", maxFlyHeight)
  } // 重载特质的抽象方法
}

object TraitDemo {
  def main(args : Array[String]) : Unit = {
    val b = new Bird(100)
    b.fly()
    b.breathe()
  }
}
