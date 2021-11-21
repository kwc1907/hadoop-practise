package add

import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable




object review {
  def main(args: Array[String]): Unit = {
    val conf =new SparkConf().setMaster("local[*]").setAppName("ss")
    val sc = new SparkContext(conf)
    val aaa=new myAccumulator()
    val vdfvdf = sc.register(aaa, "vdfvdf")
    val sdf = sc.longAccumulator("sdf")
    val rdd = sc.makeRDD(List(14, 2, 53, 6, 41))
    rdd.foreach(i=>sdf.add(i))
    println(sdf.value)
    sc.stop()
  }
class myAccumulator extends AccumulatorV2[String,mutable.Map[String,Long]]
  {
    private val wc = mutable.Map()
    override def isZero: Boolean = ???

    override def copy(): AccumulatorV2[String, mutable.Map[String, Long]] = ???

    override def reset(): Unit = ???

    override def add(v: String): Unit = ???

    override def merge(other: AccumulatorV2[String, mutable.Map[String, Long]]): Unit = ???

    override def value: mutable.Map[String, Long] = ???
  }
}
