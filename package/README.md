# package

## 定义

为了解决程序中命名冲突问题，Scala也和Java一样采用包(package)
来层次化、模块化地组织程序

```scala 
package autodepartment
class MyClass
// 为了在任意位置访问MyClass类，需要使用autodepartment.MyClass
```

通过在关键字 package 后面加大括号，可以将程序的不同部分放在不同的包里。
这样可以实现包的嵌套，相应的作用域也是嵌套的

```scala 
package glob{
       package autodepartment {
            class ControlCourse{
		...
           }
      }
     package csdepartment {
           class  OSCourse{
                val cc = new autodepartment.ControlCourse
           }
     }
}
```

## 引用包成员

可以用import 子句来引用包成员，这样可以简化包成员的访问方式

```scala 
import glob.autodepartment.ControlCourse
class MyClass{
    var myos = new ControlCourse
}
```

使用通配符下划线_引入类或对象的所有成员:

```scala 
import scala.io.StdIn._
var i = readInt()
var f = readFloat()
var str = readLine()
```

Scala 隐式地添加了一些引用到每个程序前面，
相当于每个 Scala 程序都隐式地以如下代码开始:

```scala
import java.lang._
import scala._
import Predef._
```
