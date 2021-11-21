package transform_suanzi

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

object kv_groupByKey {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.makeRDD(List(("a",5),("b",6),("a",1),("a",8)))
    val value = rdd.groupByKey()
    val tuples = value.collect()
    for(i<-tuples)
      {
        println(i._1+":"+i._2.mkString(","))
      }
    sc.stop()
  }
}
