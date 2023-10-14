object Variable {
  /*
   * Scala有两种类型的变量:
   * val: 是不可变的, 在声明时就必须被初始化, 初始化以后就不能再赋值
   * var: 是可变的, 声明的时候需要进行初始化, 初始化以后还可再次对其赋值
   */
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
