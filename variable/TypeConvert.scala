object TypeConvert {
  def main(args : Array[String]) : Unit = {
    var n1 = 10
    var n2 = 1.1f
    var n3 = n1 + n2

    var n4 : Byte = 10
    //var char1 : Char = n4 // error

    var num : Int = 2.7.toInt

    var num1 : Int = 10 * 3.5.toInt + 6 * 1.5.toInt
    var num2 : Int = (10 * 3.5 + 6 * 1.5).toInt

    var d1 = 1.2
    var s1 = d1 + ""

    val s2 = "12"
    num1 = s2.toInt
    // toByte
    // toDouble
    // toLong
  }
}
