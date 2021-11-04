package four

object yichang {
  def main(args: Array[String]): Unit = {
    try{
      val t=10/5
    }
    catch {
      case i:ArithmeticException=>
        println("算数异常")
        println("vdfgd")
      case i:Exception=>
        println("csdc")
        println("其他异常")
    }
    finally {
     println("vdfvbbbbbbbbb")
    }
  }
}
