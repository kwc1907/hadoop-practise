package third

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object test {
  def bubianarray(): Unit =
  {
    val a:Array[String]=Array("csdv","cdsv","cdfgv")
    val b=new Array[String](10)
    a(1)="sdvdf"
    val c=a:+"vdfbv":+"vdfvfd"
    for(i <- b.indices)
      b(i)="dsvd"
    val d=a++b
    println(d.mkString(","))
  }
  def bianarray(): Unit =
  {
    val a:ArrayBuffer[String]=ArrayBuffer()
    a.append("vdfv")
    a.append("vdv","vdvdf")
    a.insert(1,"cdsv","bgfh","m","vfdhh")
    a.prepend("fdgv")
    println(a.mkString(","))
    a-="cdsv"
    println(a.mkString(","))
    val b=new ArrayBuffer[String]()
    b.append("vdv","vdvdf")
    a++=b
    println(a.mkString(","))
  }
  def alllist(): Unit ={
    val a=List(14,25,36,2,255,74)
    val b=14::63::Nil
    println(a(2))
    val c=41+:78+:a:+52:+58
    println(c.mkString(","))
    val d:ListBuffer[Int]=ListBuffer()
  }
  def allSet(): Unit ={
    val a:Set[String]=Set("vdfg","vdfgv","bfghfg")
    val b=a+"sdv"
    b.foreach(ele=>print(ele+" "))
    val c:mutable.Set[String]=mutable.Set("vdsfv")
    c.add("vdfvg")
    c.add("vv")
    c.remove("vv")
    c+="vsdv"
    for (elem <- c) {
      print(elem+" ")
    }
  }
  def allmap(): Unit ={
    val a:Map[String,Int]=Map("csdv"->25,"csd"->47,"cds"->36)
    println(a.contains("csdv"))
    for(i<-a.keys)
      {
        print(i+":"+a.getOrElse(i,0))
      }
    println()
    val b=a + ("cdsv"->14)+("cds"->89)
    for(i<-b.keys)
    {
      print(i+":"+b.getOrElse(i,0))
    }
    println()
    val d:mutable.Map[String,Int]=mutable.Map("csd"->2504)
    d.put("vdfg",85)
    d.put("csd",52)
    d.put("cc",85)
    d.remove("cc")
    for(i<-d.keys)
    {
      print(i+":"+d.getOrElse(i,0))
    }
    println()
  }
  def main(args: Array[String]): Unit = {
allmap()
  }
}
