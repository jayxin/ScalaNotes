class Person(val name : String) {
  private val id = Person.newPersonId() // 调用伴生对象中的方法
  def info() { printf("The id of %s is %d.\n", name, id) }
}

object Person {
  private var lastId = 0
  def newPersonId() = { // 实现了 Java 中 static 方法的功能
    lastId += 1
    lastId
  }

  def main(args : Array[String]) {
    val person1 = new Person("Lilei")
    val person2 = new Person("Hanmei")
    person1.info()
    person2.info()
  }
}

/*
Scala 源码编译后都会变成 JVM 字节码.
在 Scala 中的 class 和 object 在 Java 层面都会被合二为一, class
里面的成员成为实例成员
object 成员成为 static 成员
*/
