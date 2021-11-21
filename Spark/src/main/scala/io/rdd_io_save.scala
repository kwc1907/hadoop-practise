package io

import org.apache.spark.{SparkConf, SparkContext}
import part.rdd_part.myPartition

object rdd_io_save {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.makeRDD(List(("nba", "zzzzz"), ("cba", "csdfdrg"), ("lba", "tttttttttttt"), ("uba", "ggggggggggggg"),("nba", "zbdfdhbszvsv")))

    sc.stop()
  }
}
