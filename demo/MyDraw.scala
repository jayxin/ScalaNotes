case class Point(var x : Double, var y : Double) extends Drawable {
  def shift(deltaX : Double, deltaY : Double) {
    x += deltaX
    y += deltaY
  }
}

trait Drawable {
  def draw() {
    println(this.toString)
  }
}

abstract class Shape(var p : Point) {
  def moveTo() {
  }

  def zoom(z : Double)
}

class Line(var x : Point, var y : Point) extends Shape(x) with Drawable {
  def zoom(z : Double) {
    var l1 : Double = math.abs(x.x - y.x)
    var l2 : Double = math.abs(x.y - y.y)
    l1 = l1 / 2.0
    l2 = l2 / 2.0
    x.shift(-z / 2.0 * l1, -z / 2.0 * l2)
    y.shift(z / 2.0 * l1, z / 2.0 * l2)
  }

  def moveTo(p : Point) {
    x = p
    y.shift(p.x, p.y)
  }

  override def draw() {
    println(s"Line: (${x.x}, ${x.y})--(${y.x}, ${y.y})")
  }
}

class Circle(var c : Point, var r : Double) extends Shape(c) with Drawable {
  def moveTo(p : Point) {
    c = p
  }

  def zoom(z : Double) {
    r *= z
  }

  override def draw() {
    println(s"Circle center:(${c.x}, ${c.y}),R=${r}")
  }
}

object MyDraw {
  def main(args : Array[String]) {
    val p = new Point(10, 30)
    p.draw
    val line1 = new Line(Point(0, 0), Point(20, 20))
    line1.draw
    line1.moveTo(Point(5, 5)) // 移动到一个新的点
    line1.draw
    line1.zoom(2) // 放大两倍
    line1.draw
    val cir = new Circle(Point(10, 10), 5)
    cir.draw
    cir.moveTo(Point(30, 20))
    cir.draw
    cir.zoom(0.5)
    cir.draw
  }
}
