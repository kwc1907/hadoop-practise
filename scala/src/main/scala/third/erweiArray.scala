package third

object erweiArray {
  def main(args: Array[String]): Unit = {
    var a=Array.ofDim[Int](2,3)
    a(0)(2)=25
    for(i <- a.indices)
    {
      for(j<-a(i).indices)
        {
          print(a(i)(j)+"\t")
        }
      println()
    }
    a.foreach(line=>{line.foreach(elem=>print(elem+"\t"));   println()})
  }
}
