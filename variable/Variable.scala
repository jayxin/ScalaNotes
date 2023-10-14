object Variable {
  def main(args : Array[String]) : Unit = {
    var a : Int = 1
    var b : Int = 3
    b = 89
    println(a)
    println(b)

    var sal : Double = 10.9
    var score : Float = 80.9f
    var name : String = "Tom"
    var isPass : Boolean = true
    println(s"${score} ${isPass}")

    var num = 10  // type inference
    println(num.isIstanceOf[Int])
    //num = 2.3 // error!

    val num1 = 30
    //num1 = 50 // error!

    val dog = new Dog
    dog.age = 90
    dog.name = "hello"
  }
}

class Dog {
  var age : Int = 0
  var name : String = ""
}
