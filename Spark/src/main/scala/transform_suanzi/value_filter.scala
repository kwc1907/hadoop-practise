package transform_suanzi

import org.apache.spark.{SparkConf, SparkContext}

object value_filter {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.makeRDD(List(14,2,36,93,85))
   val rddfilter=rdd.filter(i=>i%2==0)
    rddfilter.collect().foreach(println)
  }
}
