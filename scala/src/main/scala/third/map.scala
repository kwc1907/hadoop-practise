package third

import scala.collection.mutable

object map {
  def main(args: Array[String]): Unit = {
    val a =List(14,25,23,69,6,517,25,2)
    val b=a.filter(_%2==0)
    println(b.mkString(","))
    println("------------------------------")
    val c=a.map(i => i*2)
    println(c.mkString(","))
    println("------------------------------")
    val f:List[List[Int]]=List(List(14,25,360),List(14,25,36))
    val y=f(0):::f(1)
    val y1=f.flatten
    println(y.mkString(","))
    println(y1.mkString(","))
    println("------------------------------")
    val s=List("hello eeee","eeee dgsgv","asd asd asd","rt ju","jhjd hello hello")
    val fen=s.map(i=>i.split(" "))
    val bian =fen.flatten
    println(bian.mkString(","))
    println("------------------------------")
    val g=bian.groupBy(i=>i)
    val r=g.map(kv=>{(kv._1,kv._2.size)})
    val list = r.toList
    val tuples = list.sortWith((a: (String, Int), b: (String, Int)) => {
      a._2 > b._2
    })
    println(tuples)
    println("------------------------------")
    val k=List("sdvdv","bdfhgf","dwrwfsgv","dgdgd","bgfhgrh","fngfh")
    val t=k.groupBy((i:String)=>i(0))
    println(t)
  }
}
