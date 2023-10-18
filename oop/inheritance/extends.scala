/** 扩展类
 * Scala只支持单一继承, 而不支持多重继承.
 在类定义中使用 extends 关键字表示继承关系.
 * 重载父类的抽象成员(包括字段和方法)时, override关键字是可选的；
 而重载父类的非抽象成员时, override关键字是必选的
 * 只能重载 val 类型的字段, 而不能重载var类型的字段.
 因为 var 类型本身就是可变的, 故可直接修改它的值, 无需重载
 */

class Vehicle(speed : Int) {
  val mph : Int = speed
  def race() =
    println("Racing")
}

class Car(speed : Int) extends Vehicle(speed) {
  override val mph : Int = speed
  override def race() =
    println("Racing Car")
}

class Bike(speed : Int) extends Vehicle(speed) {
  override val mph : Int = speed
  override def race() =
    println("Racing Bike")
}

object Main extends App {
  val vehicle1 = new Car(200)
  println(vehicle1.mph)
  vehicle1.race()
  val vehicle2 = new Bike(100)
  println(vehicle2.mph)
}
