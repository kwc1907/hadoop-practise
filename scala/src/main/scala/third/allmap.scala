package third

import scala.collection.mutable

object allmap {
  def main(args: Array[String]): Unit = {
    val a:Map[String,Int]=Map("dsvdf"->14,"cdv"->25)
    val t:Map[String,Int]=Map("dfbfb"->14,"bfgng"->25)
    for(i <- a.keys)
      {
       println(a.getOrElse(i,2))
      }
    val g=a++t
    println(g)
    val b=mutable.Map("csdffv"->14,"cffsdv"->69)
    b.put("csdv",25)
    b.update("csdvdfv",85)
    println(b)
    println(a("cdv"))
  }
}
