/*
 * case类是一种特殊的类, 它们经过优化以被用于模式匹配
 * 当定义一个类时, 如果在 class 关键字前加上 case 关键字, 则该类称为 case 类
 * Scala 为 case类自动重载了许多实用的方法, 包括 toString、equals和 hashcode 方法
 * Scala 为每一个 case 类自动生成一个伴生对象
  + 1个apply方法, 因此, 实例化 case 类的时候无需使用 new 关键字
  + 1个 unapply 方法, 该方法包含一个类型为伴生类的参数,
  返回的结果是 Option 类型, 对应的类型参数是N元组,
  N是伴生类中主构造器参数的个数。
  Unapply方法用于对对象进行解构操作,
  在 case 类模式匹配中, 该方法被自动调用, 并将待匹配的对象作为参数传递给它
 */

/*// 假设有如下定义的一个 case 类:
case class Car(brand : String, price : Int)
// 编译器自动生成的伴生对象是
object Car {
  def apply(brand : String, price : Int) = new Car(brand, price)
  def unapply(c : Car) : Option[(String, Int)] = Some(c.brand, c.price)
}*/

case class Car(brand: String, price: Int)

object CaseDemo {
  def main(args : Array[String]) : Unit = {
    val myBYDCar = Car("BYD", 89000)
    val myBMWCar = Car("BMW", 1200000)
    val myBenzCar = Car("Benz", 1500000)

    for (car <- List(myBYDCar, myBMWCar, myBenzCar)) {
      car match {
        case Car("BYD", 89000) => println("Hello, BYD!")
        case Car("BMW", 1200000) => println("Hello, BMW!")
        case Car(brand, price) => println("Brand:" + brand + ", Price:" + price + ", do you want it?")
      }
    }
  }
}
