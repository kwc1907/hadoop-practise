package third

import scala.collection.mutable

object nobianset {
  def main(args: Array[String]): Unit = {
    val a=Set(14,25,14,36,52,48,25)
    println(a)
    val b=a+25
    println(b)
    val c=Set(42,54,5615,45)
    val d=c++a
    val e=c-54
    println(e)
    val f=mutable.Set(14,2,23,55)
    f.add(36)
    println(f)
  }
}
