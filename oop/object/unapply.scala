/** unapply 方法
 * unapply方法用于对对象进行解构操作,与apply方法类似,该方法也会被自动调用
 * 可以认为unapply方法是apply方法的反向操作,apply方法接受构造参数变成对象,
 而unapply方法接受一个对象,从中提取值
 * unapply 方法接受一个实例对象然后返回最初创建它所用的参数
 * unapply方法会返回一个Option,其内部生成一个Some对象,
 这个Some对象是做相似对象的封装。
 * unapply 方法的返回值应当符合如下规则：
 * 若只是用来判断真假，可以返回一个 Boolean 类型的值,如 case even()。
 * 若只是用来提取单个 T 类型的值，可以返回 Option[T]
 * 若想要提取多个值，类型分别为 T1,...,Tn，可以把它们放在一个可选的元组中
 Option[(T1,...,Tn)]
 */

class Car(val brand : String, val price : Int) {
  def info() { println("Car brand is " + brand + " and price is " + price) }
}

object Car {
  def apply(brand : String, price : Int) = {
    println("Debug: calling apply...")
    new Car(brand, price)
  }

  def unapply(c : Car) : Option[(String, Int)] = {
    println("Debug: clling unapply...")
    Some((c.brand, c.price))
  }
}

object TestUnaply {
  def main(args : Array[String]) {
    var Car(carbrand, carprice) = Car("BMW", 8000000)
    println("brand: " + carbrand + " and carprice: " + carprice)
    // 变量定义可以使用模式引入变量, 提取器可以用来初始化这个变量,
    // 使用unapply方法来生成值
  }
}
