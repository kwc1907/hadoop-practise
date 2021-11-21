package transform_suanzi

import org.apache.spark.{SparkConf, SparkContext}

object doublevalue_jiaobingcha {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd1 = sc.makeRDD(List(14, 25, 36, 74),1)
    val rdd2=sc.makeRDD(List(14,25,96,8,57,4))
    val herdd=rdd1.intersection(rdd2)
    println(herdd.collect().mkString(","))
  }
}
