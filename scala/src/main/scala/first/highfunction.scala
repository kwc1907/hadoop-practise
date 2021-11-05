package first

object highfunction {
  def main(args:Array[String]):Unit={
    def shuzu(array:Array[Int],op:Int=>Int):Array[Int]={
      for (elem <- array) yield op(elem)
    }
    val arr=Array(14,25,369,68,45)
    val add=(a:Int)=>a+2
    val cheng=(a:Int)=>a*3
    for (elem <- shuzu(arr,cheng)) {println(elem)}
    val fun = (a:Int,b:String,c:Char)=>{
                                  if(a==0 && b==""&&c=='0')
                                    false else true}
    println(fun(0,"",'0'))

    def func(a:Int):String=>Char => Boolean  =
    {
      b=>{c=>{if(a==0 && b==""&&c=='0')
        false else true}}
    }
    println(func(0)("h")('0'))
  }
}
