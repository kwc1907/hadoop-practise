package transform_suanzi

import org.apache.spark.{SparkConf, SparkContext}

object kv_join {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.makeRDD(List(("a",5),("b",6),("a",1),("a",8),("c",7),("c",2)))
    val rdd1=sc.makeRDD(List(("a",5),("b",6),("a",1),("a",8),("c",7),("d",8)))
    val value = rdd.join(rdd1)
    val tuples = value.collect()
    for(i<-tuples)
      {
        println(i._1+":"+i._2._1+"   "+i._2._2)
      }
    sc.stop()
  }
}
