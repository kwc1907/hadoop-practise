package third

object yuanzu {
  def main(args: Array[String]): Unit = {
    val a=("cdv",14,"vdfv",85,74,36)
    for(i <- a.productIterator)
      {
        println(i)
      }
  }
}
