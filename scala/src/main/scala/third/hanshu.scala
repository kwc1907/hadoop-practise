package third

object hanshu {
  def main(args: Array[String]): Unit = {
    val b=Array("csdvreg","vdfv","vdsfv","brf")
    val a=Array(14,253,6)
    println(a.head)
    println(a.reverse.mkString(","))
    val tuples = b.zip(a)
    val d=tuples.toMap
    println(d("vdfv"))
    b.max
    val c=b.sorted(Ordering[String].reverse)
    println(b.mkString("-"))
    println(c.toBuffer)
    val r=a.sortWith(_>_)//a.sortWith((a,b)=>a>b)
    println(r.toBuffer)
  }
}
