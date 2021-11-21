package transform_suanzi

import org.apache.spark.{SparkConf, SparkContext}

object value_mapPartitions {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.makeRDD(List(14,25,36,58),2)
    val rddmap = rdd.mapPartitions(i => {
      List(i.max).iterator
    })
    rddmap.collect().foreach(println)
  }
}
