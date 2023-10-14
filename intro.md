# Scala

- Scala 基于 JVM, 和 Java 完全兼容, 同样具有跨平台、可移植性好、方便的垃圾回收等特性;
- Scala 比 Java 更加面向对象;
- Scala 是一门函数式编程语言;
- Scala 更适合大数据的处理, 对集合类型数据处理有非常好的支持
- Spark 的底层用 Scala 编写

## 主要内容

- 基本语法
    1. 变量和数据类型
    2. 运算符
    3. 流程控制
- 核心特性
    1. 函数式编程
    2. 面向对象
    3. 集合
- 其他
    1. 模式匹配
    2. 异常处理
    3. 隐式转换
    4. 泛型

## Introduction

- 编程范式是指计算机编程的基本风格或典范模式.
- 常见的编程范式主要包括命令式编程和函数式编程.
面向对象编程就属于命令式编程, 如 Cpp、Java 等.
- 命令式语言是植根于冯·诺依曼体系的, 一个命令式程序就是一个冯·诺依曼机的指令序列,
给机器提供一条又一条的命令序列让其原封不动地执行.
- 函数式编程, 又称泛函编程, 它将计算机的计算视为数学上的函数计算.
- 函数编程语言最重要的基础是 λ 演算. 典型的函数式语言包括 Haskell、Erlang 和 Lisp 等.

### 为何需要函数式编程?

- 命令式编程涉及多线程之间的状态共享，需要锁机制实现并发控制.
- 函数式编程不会在多个线程之间共享状态, 不需要用锁机制，
可以更好并行处理，充分利用多核 CPU 并行处理能力.

### Scala

1. Martin Odersky : Scala 之父
2. James Gosling : Java 之父

- Scala 是一门类 Java 的多范式语言，它整合了面向对象编程和函数式编程的最佳特性. 
- Scala 运行于 Java 虚拟机（JVM）之上，并且兼容现有的 Java 程序, 可以与Java类进行互操作,
包括调用 Java 方法，创建 Java 对象，继承 Java 类和实现 Java 接口.
- Scala 是一门纯粹的面向对象的语言. 在 Scala 中，每个值都是对象，
每个操作都是方法调用. 对象的数据类型以及行为由**类**和**特质**描述. 
类抽象机制的扩展有两种途径，一种途径是子类继承，另一种途径是灵活的混入（mixin）机制，
这两种途径能避免多重继承的种种问题.
- Scala 也是一门函数式语言. 在 Scala 中，每个函数都是一个值， 且和其他类型（如整数、字符串等）的值处于同一地位. 
Scala 提供了轻量级的语法用以定义匿名函数， 支持高阶函数，允许嵌套多层函数，并支持柯里化.

#### Install

1. 下载;
2. 解压;
3. 配置环境变量.

```scala 
// HelloWorld.scala
object HelloWorld {
    def main(args : Array[String]) : Unit = {
        println("Hello, world!")
    }
}
```

常用命令:

```bash
scala # 进入 REPL
scalac
# 可类比 java 和 javac

scalac HelloWorld.scala
scala -classpath . HelloWorld
# or
java -classpath .:$SCALA_HOME/lib/scala-library.jar HelloWorld
```

#### REPL

```scala 
// hello.scala
println("This is the first line")
println("This is the second line")
println("This is the third line")
```

```scala
:help // 获得帮助
:load hello.scala // 从当前目录加载
:quit // 退出 REPL
```
