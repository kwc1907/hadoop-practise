package third

import scala.collection.mutable.ArrayBuffer

object bianarray {
  def main(args: Array[String]): Unit = {
    val a=new ArrayBuffer[Int]()
    val b=ArrayBuffer(25,96,74,85)
    a.append(14,258,569)
    a.prepend(25,3696,7474)
    a.insert(3,14,25)
    a.remove(2)
    println(a)
    a-=14
    println(a)
    val c=a.toArray
    val r=c :+14
    for(i <-c)
      println(i)
    r.foreach(println)
    val o=Array(12,14,25,36,95,24)
    val e=o.toBuffer
    println(e)
  }
}
