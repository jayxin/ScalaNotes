/** 函数的定义
 * 定义函数最通用的方法是作为某个类或者对象的成员，这种函数被称为方法，
 其定义的基本语法为
 * def 方法名(参数列表) : 返回类型 = { 方法体 }
 * 字面量包括整数字面量、浮点数字面量、布尔型字面量、字符字面量、字符串字面量、
 符号字面量、函数字面量和元组字面量，
 除了函数字面量外，其他几种字面量都很容易理解
 * 函数字面量可以体现函数式编程的核心理念
 * 在函数式编程中，函数是“头等公民”，可以像任何其他数据类型一样被传递和操作，
 也就是说，函数的使用方式和其他数据类型的使用方式完全一致了
 * 这时，我们就可以像定义变量那样去定义一个函数，由此导致的结果是，
 函数也会和其他变量一样，开始有“值”
 * 就像变量的“类型”和“值”是分开的两个概念一样，函数式编程中，
 函数的“类型”和“值”也成为两个分开的概念，函数的“值”，就是“函数字面量”
 */

def max(x : Int, y : Int) : Int = {
  if (x > y)
    x
  else
    y
}

val i = 123
val j = 1.23
val k = true
val l = 'A'
val m = "Hello"

/*
函数的“类型”和“值”的概念：在定义一个传统类型的函数，
定义的语法和介绍过的定义“类中的方法”类似（实际上，
定义函数最常用的方法是作为某个对象的成员，这种函数被称为方法）：
*/
def counter(value : Int) : Int = { value += 1 }

// 上面定义的函数的类型如下
//(Int) => Int
// 实际上，只有多个参数时（不同参数之间用逗号隔开），
// 圆括号才是必须的，当参数只有一个时，圆括号可以省略，如下：
//Int => Int

// 实际上，我们只要把函数定义中的类型声明部分去除，
// 剩下的就是函数的“值”，如下：
//(value) => { value += 1 } // 只有一条语句时, 花括号可省略

/*
我们再按照定义变量的方式，采用Scala语法来定义一个函数，
声明一个变量时，我们采用的形式是：
val num : Int = 5
*/
// 也可以按照上面类似的形式来定义Scala中的函数：
val counter : Int => Int = { (value) => value += 1 }
/*
从上面可以看出，在Scala中，函数已经是“头等公民”，单独剥离出来了“值”的概念，
一个函数“值”就是函数字面量。这样，
我们只要在某个需要声明函数的地方声明一个函数类型，
在调用的时候传一个对应的函数字面量即可，和使用普通变量一模一样
*/

// 不需要给每个函数命名，这时可以使用匿名函数(Lambda 表达式)：
// (参数) => 表达式
// 若参数仅有一个, 圆括号可以省略
(num : Int) => num * 2

val myNumFunc : Int => Int = (num : Int) => num * 2
println(myNumFunc(3)) // 6

val myNumFunc = (num : Int) => num * 2 // type inference
println(myNumFunc(3)) // 6

val myNumFunc : Int => Int = (num) => num * 2 // type inference

// 当函数的每个参数在函数字面量内仅出现一次，
// 可以省略“=>”并用下划线“_”作为参数的占位符来简化函数字面量的表示，
// 第一个下划线代表第一个参数，第二个下划线代表第二个参数，依此类推
val counter = (_ : Int) + 1 // 有类型时括号不能省略, 等效于 x : Int => x + 1
val add = (_ : Int) + (_ : Int) // IFF (a : Int, b : Int) => a + b
val m1 = List(1, 2, 3)
val m2 = m1.map(_ * 2) // IFF m1.map(x => x * 2), 参数类型可根据 m1 的元素类型推断

/*
高阶函数：当一个函数包含其它函数作为其参数或者返回结果为一个函数时，
该函数被称为高阶函数
*/

/*
例：假设需要分别计算从一个整数到另一个整数的“连加和”、
“平方和”以及“2的幂次和”
*/
// 不采用高阶函数
def powerOfTwo(x : Int) : Int = {
  if (x == 0) 1
  else 2 * powerOfTwo(x - 1)
}

def sumInts(a : Int, b : Int) : Int = {
  if (a > b) 0
  else a + sumInts(a + 1, b)
}

def sumSquares(a : Int, b : Int) : Int = {
  if (a > b) 0
  else a * a + sumSquares(a + 1, b)
}

def sumPowersOfTwo(a : Int, b : Int) : Int = {
  if (a > b) 0
  else powerOfTwo(a) + sumPowersOfTwo(a + 1, b)
}

// 采用高阶函数
def sum(f : Int => Int, a : Int, b : Int) : Int = {
  if (a > b) 0
  else f(a) + sum(f, a + 1, b)
}
sum(x => x, 1, 5)
sum(x => x * x, 1, 5)
sum(powerOfTwo, 1, 5)
