// + - * / %
// == != > < >= <=
// && || !
// & | ^ ~ << >> >>>
// = += -= *= /= %=
// <<= >>= &= ^= |=

object Operator {
  def main(args : Array[String]) : Unit = {
    var r1 : Int = 10 / 3
    var r2 : Double = 10 / 3
    var r3 : Double = 10.0 / 3
    println(r3.formatted("%.2f"))

    // a % b = a - (a/b) * b
    println(10 % 3) // 1
    println(10 % -3) // 1
    println(-10 % 3) // -1
    println(-10 % -3) // -1

    var num1 = 10
    num1 += 1
    num1 -= 1

    var a = 9
    var b = 8
    println(a > b)
    println(a < b)
    println(a <= b)
    println(a >= b)
    println(a == b)
    println(a != b)

    var flag : Boolean = a > b
    println(true)

    // swap
    a = a + b
    b = a - b
    a = a - b

    val num = if (a > b) a else b

    val sum1 = 5 + 3
    val sum2 = (5).+(3)
    println(sum1, sum2)
  }
}

/*
 * 对基本数据类型, 除以上提到的各种操作符外, Scala还提供了许多常用运算的方法,
只是这些方法不是在基本类里面定义, 而是被封装到一个对应的富包装类中.
 * 每个基本类型都有一个对应的富包装类, 如 Int 有一个 RichInt 类、
String有一个 RichString 类, 这些类位于包scala.runtime中
 * 当对一个基本数据类型的对象调用其富包装类提供的方法,
Scala会自动通过隐式转换将该对象转换为对应的富包装类型, 然后再调用相应的方法.
如: 3 max 5
 */
