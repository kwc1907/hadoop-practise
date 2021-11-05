package third

import scala.collection.mutable.ListBuffer

object nobianlist {
  def main(args: Array[String]): Unit = {
    val a=List(14,25,369,6)
    val b=14::58::96::74::Nil
    val c =a:::b
    val d=a++b
    println(c(5))
    val e=new ListBuffer[Int]()
    val f=ListBuffer(14,25,360)
    f.append(14)
    f(2)=175
  }
}
