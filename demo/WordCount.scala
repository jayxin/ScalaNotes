import java.io.File
import scala.io.Source
import collection.mutable.Map

object WordCount {
  def main(args: Array[String]) {
    // 假设当前目录下有一个 testfiles 目录且包含若干文本文件
    val dirfile = new File("testfiles")
    val files  = dirfile.listFiles

    val results = Map.empty[String, Int]

    for (file <- files) {
      val data = Source.fromFile(file)
      val strs = data.getLines.flatMap{ s => s.split(" ") }

      strs foreach { word => {
          if (results.contains(word))
            results(word) += 1
          else
            results(word) = 1
        }
      }
    }

    results foreach { case (k, v) => println(s"$k:$v") }
  }
}
