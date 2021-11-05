package four

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object NEW {

  def pipei(x:Any):String=x match{
    case d:Int => "it is int type"

  }
  def main(args:Array[String]):Unit={
      val x = "1"
      val y = x match {
        case "1" =>
          println("vdsvf")
          "one"
        case "2" =>
          println("csdfdf")
          println("vdfgvdfg")
          "two"
        case "3" =>
          println("csdf")
          println("vdfg")
          "three"
        case _ =>
          "sb input worong"

      }
      println(y)


    val t:Int=(-58)
    println(
      t match{
        case i if i<0 => -i
        case i if i>0 => i
      }
    )


  }

}

