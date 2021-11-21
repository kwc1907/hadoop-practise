package transform_suanzi

import org.apache.spark.{SparkConf, SparkContext}

object value_sample {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.makeRDD(List(14,14,75,89,8,5,9,82,92))
    println(rdd.sample(false,0.4).collect().mkString(","))
  }
}
