/*
 * 单例对象
 * apply 方法
 * update 方法
 * unapply 方法
 */

/*
 * Scala采用单例对象singleton object实现与Java静态成员同样的功能
 * 单例对象是一种特殊的类，有且只有一个实例，
 单例对象是延迟创建的，当它第一次被使用时创建
 * 使用object 关键字定义单例对象
 * 创建功能性方法是单例对象的一种常见用法
 */

object Person {
  private var lastId = 0;
  def newPersonId() = {
    lastId += 1
    lastId
  }
}

/*
伴生对象和孤立对象:
当一个单例对象和某个类共享一个名称时，
这个单例对象被称为这个同名类的伴生对象(companion object),
相应的类被称为这个单例对象的伴生类

类和它的伴生对象必须存在于同一个文件中，可以相互访问私有成员，
如需要在 REPL 里定义类和其伴生对象，需要将它们定义在同一行

使用伴生对象来定义那些在伴生类中不依赖于实例化对象而存在的成员变量或者方法

没有同名类的单例对象，被称为孤立对象(standalone object)。
一般情况下，Scala程序的入口点main方法就是定义在一个孤立对象里
*/

object ObjectDemo {
  def main(args : Array[String]) : Unit = {
    printf("The first person id: %d.\n", Person.newPersonId())
    printf("The second person id: %d.\n", Person.newPersonId())
    printf("The third person id: %d.\n", Person.newPersonId())
  }
}
