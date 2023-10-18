trait Flyable {
  var maxFlyHeight : Int // 抽象字段
  def fly() // 抽象方法

  def breathe() {
    println("I can breathe")
  }
}

trait HasLegs {
  val legs : Int // 抽象字段

  def move() {
    printf("I can walk with %d legs\n", legs)
  }
}

class Animal(val category : String) {
  def info() {
    println("This is a " + category)
  }
}

class Bird(flyHeight : Int) extends Animal("Bird") with Flyable with HasLegs {
  var maxFlyHeight : Int = flyHeight // 重载特质的抽象字段
  val legs = 2 // 重载特质的抽象字段

  def fly() {
    printf("I can fly at the height of %d\n", maxFlyHeight)
  } // 重载特质的抽象方法
}

object TraitDemo1 {
  def main(args : Array[String]) : Unit = {
    val b = new Bird(108)
    b.info
    b.fly
    b.move
  }
}
