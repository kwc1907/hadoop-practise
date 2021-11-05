package four

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object fuxi {
  def asdarray(): Unit ={
    val a:Array[Int]=Array(78,14,25,32,14,36,82)
    val a1=new Array[Int](10)
    val b=new ArrayBuffer[Int]()
    val b1:ArrayBuffer[Int]=ArrayBuffer()
    for(i <- a.indices)
    {print(a(i)+" ")}
    println()
    a1(9)=25
    val a2=a:+14
    println(a2.mkString(","))
    val a3=a++a1
    for(i<-a3)
      {
        print(i+" ")
      }
    println()
    b.append(14,25,36)
    b.prepend(78,48,6,165)
    b-=25
    b+=85
    b.insert(1,11,1,11,1,11)
    val b2=b1++=b
    b2.foreach(i=>print(i+" "))
    println()
  }
  def asdlist(): Unit ={
    val a=List(14,25,3,641,442)
    val a3=25::Nil
    println(a(2))
    val a1=a:+14
    val b:ListBuffer[Int]=ListBuffer(14,25,36,85,51)
    b-=36
    b(3)=254
    println(b.mkString(","))
  }
  def asdSet(): Unit ={
    val a=Set("dfgd","vdfvge","cdsvfdf")
    for (i <- a) {print(i+" ")}
    println()
    val b:mutable.Set[String]=mutable.Set()
    b+="vdvgd"
    val c:mutable.Set[String]=mutable.Set()
    c+="csdv"+="cdsvvgfdg"
    c++=b
    println(c.mkString(","))
  }
  def asdmap(): Unit ={
    val a=Map("csdv"->14,"vdvdf"->36,"csdvd"->14)
    a+("csdv25"->25)
   for(i <- a.keys)
      {
        print(i+":"+a.getOrElse(i,0)+" ")
      }
    println()
    val b:mutable.Map[String,Int]=mutable.Map("vcsdv"->25,"csdvd"->36)
    b.put("brthrt",85)
    b.remove("csdvd")
    b-="vcsdv"
    println(b)
  }
  def asdyuan(): Unit ={
    val a=(14,25,3,61,4)
    println(a._3)
  }
  def main(args:Array[String]):Unit={
    val a=Array(14,25,36,85,72,2,63,54)
    val b=Map("csdvd"->14,"csdgf"->85,"vdfv"->78)
    println(a.length+","+","+a.contains(25))
    println(a.sum+" "+a.min)
    val c=b.maxBy((i:(String,Int))=>i._2)
    println(c)
    val r=a.sortWith((y:Int,x:Int)=>y>x)
    println(r.mkString(","))
    val t=a.filter(i=>i%2==0)
    println(t.toBuffer)
    val u:Array[String]=Array("cvdfg gvrdg","vsdg asdasd","asdasd asdasd asdasd","hbtyhgds vsdg csbgfh llbgfb oioui cvdfg" )
    val s = u.flatMap((i: String) => {
      i.split(" ")
    })
    println(s.mkString(","))
    val y=s.groupBy(i=>i)
    val o=y.map((i:(String,Array[String]))=>(i._1,i._2.length))
    val n=o.toArray
    val k=n.sortWith((i:(String,Int),j:(String,Int))=> i._2>j._2)
    for (i <- k) {
      print(i._1+":"+i._2+" ")
    }
    println()
    val v=a.reduce((i:Int,j:Int)=>i+j)
    println(v)

    val m1=mutable.Map("a"->2,"b"->9,"c"->5,"g"->8,"t"->47)
    val m2=mutable.Map("a"->8,"b"->8,"c"->7,"g"->3,"l"->6)
    val m3=m1.foldLeft(m2)(
      (ma,kv)=>
       {ma(kv._1)=ma.getOrElse(kv._1,0)+kv._2
      ma}
    )
println(m3)
  }

}
