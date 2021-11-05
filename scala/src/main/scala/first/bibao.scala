package first

object bibao {
  def main(args: Array[String]): Unit = {
    def addbyA(a:Int):Int=>Int={
      def bian(b:Int)={
        a+b
      }
      bian
    }
  println(addbyA(5)(36))
  }
 def adda(a:Int)(b:Int)=a+b

}
