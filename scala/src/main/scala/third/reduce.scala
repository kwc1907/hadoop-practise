package third

import scala.collection.mutable

object reduce {
  def main(args: Array[String]): Unit = {
    val a=List(14,258,39,124,75,2)
    val b=a.reduce((a:Int,b:Int)=>a+b)
    println(b)
    val c=mutable.Map("a"->1,"b"->3,"c"->9)
    val d=mutable.Map("a"->9,"b"->4,"c"->9,"d"->14)
    val e=c.foldLeft(d)(
      (ma,kv)=>{
        val key=kv._1
        val value=kv._2
        ma(key)=ma.getOrElse(key,0)+value
        ma
      }
    )
    println(e)
  }
}
