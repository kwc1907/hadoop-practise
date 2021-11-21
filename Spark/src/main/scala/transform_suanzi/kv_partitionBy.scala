package transform_suanzi

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

object kv_partitionBy {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.makeRDD(List(14, 25, 36, 74))
    val rddmap = rdd.map((_, 1))
    rddmap.partitionBy(new HashPartitioner(2))

    sc.stop()
  }
}
