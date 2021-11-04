package first

object nimingfunction {
  def main(args:Array[String]):Unit={
    def niming(fun:(String,Int)=>Unit)=fun("kwc",25)
    niming((name,age)=>println(name+":"+age))

    def eryuan(fun:(Int,Int)=>Int):Int= fun(1,2)
    println(eryuan((a,b)=>a*b))
    println(eryuan(_+_))

    def eryuan1(fun:(Int,Int)=>Int,a:Int,b:Int)=fun(a,b)
    println(eryuan1(_*_,5,6))
    println(eryuan1((a,b)=>a*b,7,9))

  }
}
