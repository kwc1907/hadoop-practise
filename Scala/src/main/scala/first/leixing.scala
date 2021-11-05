package first

object leixing {
  def main(args:Array[String]):Unit={
    val a:Byte=47
    val b:Short=36
    val c:Int=362
    val d:Long=9622222
    val aa=1036.33
    val bb='\t'
    println(s"${a}${bb}${aa}")
    val g='d'
    println(g+0)
    val r="4755"
    val u=r.toInt
    println(u+58)
    def m1(asd:String):String= {
      println("zhixing"+asd)

      return "ffff"
    }
    val str = m1("ds")
    print(str)
    def m2(i:Int):Int={
      if(i==0)
        throw new NullPointerException
      else return i
    }

  }
}
