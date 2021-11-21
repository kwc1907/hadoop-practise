package rdd

import org.apache.spark.{SparkConf, SparkContext}

object rdd_memory_par {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("rdd")
    val sc = new SparkContext(conf)
    val rdd = sc.makeRDD(List(14, 25, 3, 68, 1, 58),2)
    rdd.saveAsTextFile("C:\\Users\\若久\\Desktop\\随缘记事本\\output")
    sc.stop()
  }
}
