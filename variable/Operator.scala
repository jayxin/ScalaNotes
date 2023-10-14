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
  }
}
