package four

object yanglilei {
  def main(args: Array[String]): Unit = {
    val a=student74("kwc",58)
    a match {
      case student74("kwc",58) => println("success")
      case _=> println("shibai")
    }
  }
}

case class student74(val name:String,val age:Int)
