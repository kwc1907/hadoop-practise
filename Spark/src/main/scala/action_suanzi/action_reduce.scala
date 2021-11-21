package action_suanzi

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object action_reduce {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd=sc.makeRDD(List(1,2,3,4))
    val r=rdd.reduce(_+_)
    println(r)
    val rdd1: RDD[Int] = sc.makeRDD(List(1,3,2,4))
    val result: Array[Int] = rdd1.takeOrdered(2)
    println(result.mkString(","))
    sc.stop()
  }
}
