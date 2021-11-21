package add

import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

object acc_wordcount {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("suiyi")
    val sc=new SparkContext(conf)
    val rdd = sc.makeRDD(List("vdfvd csdv asd", "asd asd asd asd", "dvbdfb kwc vsvg asd", "kwc jj jj vsvg"))
    val value = rdd.flatMap(_.split(" "))
    val my=new myAccumulator()
    
    value.foreach(i=>my.add(i))
    println(my.value)
    sc.stop()
  }
  class myAccumulator extends AccumulatorV2[String,mutable.Map[String,Int]]
  {
    private var wc=mutable.Map[String,Int]()
    override def isZero: Boolean = wc.isEmpty

    override def copy(): AccumulatorV2[String, mutable.Map[String, Int]] = new myAccumulator()

    override def reset(): Unit = wc.clear()

    override def add(v: String): Unit =
      {
        val newcount=wc.getOrElse(v,0)+1
        wc.update(v,newcount)
      }

    override def merge(other: AccumulatorV2[String, mutable.Map[String, Int]]): Unit = {
      val map1=this.wc
      val map2=other.value
      map2.foreach(i=>{
        val newword=map1.getOrElse(i._1,0)+i._2
        map1.update(i._1,newword)
      })
    }

    override def value: mutable.Map[String, Int] =
      {
        wc
      }
  }
}
