package first

object digui {
  def main(args: Array[String]): Unit = {
    def jiecheng(i:Int):Int={
      if(i==1)
         i
      else
      i*jiecheng(i-1)
    }
    println(jiecheng(5))
    def weijigui(n:Int,curr:Int):Int={
      if (n==0) return curr
      weijigui(n-1,n*curr)
    }

  }
}
