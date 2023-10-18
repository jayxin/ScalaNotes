/*
 * 与apply方法类似的update方法也遵循相应的调用约定：
 当对带有括号并包括一到若干参数的对象进行赋值时,编译器将调用对象的update方法
 ,并将括号里的参数和等号右边的值一起作为update方法的输入参数来执行调用
 */

val myStrArr = new Array[String](3)
myStrArr(0) = "BigData" // 调用伴生类 Array 中的 update 方法, myStrArr.update(0, "BigData")
myStrArr(1) = "Spark" // myStrArr.update(1, "Spark")
