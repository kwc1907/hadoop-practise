package first

import java.io.{File, FileOutputStream, FileWriter}

import scala.io.{Source, StdIn}

object input {
  def main(args:Array[String]):Unit={
   /* val in:String=StdIn.readLine()
    val age=StdIn.readInt()
    println(s"in:${in},age:${age}")*/
    Source.fromFile("C:\\Users\\若久\\Desktop\\随缘记事本\\c++.txt").foreach(print)
    val writer = new FileWriter("C:\\Users\\若久\\Desktop\\随缘记事本\\ww.txt")
    writer.write(25)
    writer.close()
  }
}
