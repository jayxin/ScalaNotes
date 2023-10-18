/*
 * 若一个类包含没有实现的成员，则必须使用 abstract 关键词进行修饰，
 定义为抽象类
 * 定义一个抽象类，需要使用关键字abstract
 * 定义一个抽象类的抽象方法，不需要关键字abstract，只要把方法体空着，
 不写方法体就行
 * 抽象类中定义的字段，只要没有给出初始化值，就表示是一个抽象字段，
 但是，抽象字段必须要声明类型，否则编译会报错
 */

abstract class Car(val name : String) {
  val carBrand : String // 抽象字段
  def info() // 抽象方法
  def greeting() {
    println("Welcome to my car!")
  }
}
