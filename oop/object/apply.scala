/*
 * val myStrArr = Array("BigData", "Hadoop", "Spark")
 * Sclaa 自动调用 Array 类的伴生对象 Array 中的一个称为 apply 的方法创建一个
 Array 对象 myStrArr
 * apply方法调用约定: 用括号传递给类实例或单例对象名一个或多个参数时,
 Scala 会在相应的类或对象中查找方法名为apply且参数列表与传入的参数一致的方法,
 并用传入的参数来调用apply方法
 * apply方法的最佳实践方式之一就是用来做工厂
 (工厂模式: 通过定义工厂父类负责定义创建对象的公共接口,
   而子类则负责生成具体的对象)。如在Scala的标准库中,
 许多集合类提供了apply方法来创建集合
 */

/*var arr = new Array[Int](3)
var arr = Array("BigData", "Hadoop", "Spark")

def apply(x : Int, xs : Int *) : Array[Int] = {
  val array = new Array[Int](xs.length + 1)
  array[0] = x
  var i = 1
  for (x <- xs.iterator) { array(i) = x; i += 1 }
  array
}*/
// xs : Int* 表示变长参数

// 类中的 apply 方法
/*class TestApplyClass {
  def apply(param : String) {
    println("apply method called: " + param)
  }
}
val myObject = new TestApplyClass
myObject("Hello Apply")
myObject.apply("Hello Apply")*/

// 伴生对象中的 apply 方法: 将所有类的构造方法以 apply 方法的形式定义在
// 伴生对象中, 这样伴生对象就像生成类实例的工厂, 这些 apply 方法也被称为工厂方法
class Car(name : String) {
  def info() { println("Car name is " + name) }
}

object Car {
  def apply(name : String) = new Car(name) // 调用伴生类的构造方法
}

object MyTestApply {
  def main(args : Array[String]) {
    val mycar = Car("BMW") // 调用伴生对象中的 apply 方法
    mycar.info()
  }
}

/** 为什么要有 apply 方法
 * 保持对象和函数之间使用的一致性
 * 面向对象: "对象.方法" VS  数学: "函数(参数)"
 * Scala中一切都是对象, 包括函数也是对象。
 Scala中的函数既保留括号调用样式, 也可以使用点号调用形式,
 其对应的方法名即为apply
 * Scala的对象也可以看成函数,前提是该对象提供了apply方法
 * 可以把类的所有构造方法以apply方法的形式定义在它的伴生对象中,
 这样伴生对象的方法就会自动被调用, 生成类对象
 */
