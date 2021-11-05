package third
object nobianarray {
  def main(args: Array[String]): Unit = {
    val a=new Array[Int](10)
    val b=Array(14,25,36,9,96)
    for(i <- 0 until b.length)
      println(b(i))

    for(i <- b.indices)
      println(b(i))

    for(i <- b)
      println(i)

    val iter=b.iterator
    while(iter.hasNext)
    {
      println(iter.next())
    }

    b.foreach(println)

    println(b.mkString("--"))

    val c=b.:+(36)
    c.foreach(println)

    val c1= b :+47 :+48
    val c2=58 +:47 +:b
    println("-----------------")
    val o=c1++c2
    o.foreach(println)
  }
}
