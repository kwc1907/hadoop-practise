package add

import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

import scala.collection.mutable

object heji {
  def main(args:Array[String]):Unit={
    val conf = new SparkConf().setMaster("local[*]").setAppName("heji")
    val sc = new SparkContext(conf)
    val rdd = sc.makeRDD(List("csdvd assad asd asd", "oo oi oo ai ai", "oo ll kwck wc kwc kwc", "ll kwc"))
    val flatrdd=rdd.flatMap(_.split(" "))
    val myAcc=new myAccumulator()
    sc.register(myAcc,"my")
    flatrdd.foreach(i=> myAcc.add(i))
    println(myAcc.value)
    sc.stop()
  }
  class mypartition(number:Int) extends Partitioner {
    override def numPartitions: Int = number

    override def getPartition(key: Any): Int = {
      key match {
        case "kwc" => 0
        case "kk" => 1
        case _ => 2
      }
    }
  }
  class myAccumulator extends AccumulatorV2[String,mutable.Map[String,Long]] {
    private var wc = mutable.Map[String,Long]()
    override def isZero: Boolean = wc.isEmpty

    override def copy(): AccumulatorV2[String, mutable.Map[String, Long]] = new myAccumulator()

    override def reset(): Unit = wc.clear()

    override def add(v: String): Unit = {
      val newcount=wc.getOrElse(v,0L)+1L
      wc.update(v,newcount)
    }

    override def merge(other: AccumulatorV2[String, mutable.Map[String, Long]]): Unit = {
      val map1=this.wc
      val map2=other.value
      map2.foreach(i=>{
        val newcount=map1.getOrElse(i._1,0L)+i._2
        map1.update(i._1,newcount)
      })
    }

    override def value: mutable.Map[String, Long] = {
    wc
    }
  }
}
