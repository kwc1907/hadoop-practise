package third

object bing {
  def main(args: Array[String]): Unit = {
    val strings = (1 to 100).map(
      x => Thread.currentThread.getName
    )
    val strings1 = (1 to 100).par.map(
      x => Thread.currentThread.getName
    )
    println(strings1)
  }
}
