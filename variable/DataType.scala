object DataType {
  def main(args : Array[String]) : Unit = {
    var num1 : Int = 10
    println(s"${num1.toDouble}\t${num1.toString}${100.toDouble}")

    var isPass = true
    println(isPass.toString)

    sayHi()

    println(Long.MaxValue)
    println(Long.MinValue)

    println(5.12)
    println(5.12f)
    println(.512)
    println(5.12e2)
    println(5.12e-2)

    // Char 2 bytes
    // U+0000 U+FFFF

    var char1 : Char = 97
    println(char1) // a
    println(char1 + 1) // 98
    println('A') // A
  }

  def sayHi() : Unit = {
    println("say hi")
  }
}

/*Any
  AnyVal
    Double(8B)
    Unit
    Float(4B)
    Long(8B)
    Int(4B)
    Short(2B)
    Boolean
    Char(2B)
    String
    Byte(1B)
      Nothing
  AnyRef
    Scala collections
    Other Scala classes
    (all java classes)
      Null
        Nothing*/

/*
Int IFF scala.Int
Scala 用 java.lang.String 类来表示字符串
*/
