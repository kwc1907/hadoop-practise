package first

object Lazy {
  def main(args: Array[String]): Unit = {
    lazy val res:Int = sum(10,30)
    println("cdvdfvgdgfg")
    println(res)
  }
  def sum(a:Int,b:Int):Int={
    println("dsdsvsd")
    a+b
  }
}
