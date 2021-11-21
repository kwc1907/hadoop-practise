package transform_suanzi

import org.apache.spark.{SparkConf, SparkContext}

object kv_aggregateBykey {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.makeRDD(List(("a",5),("b",6),("a",1),("a",8),("c",7),("c",2)))
    val value = rdd.aggregateByKey(0)((x,y)=>math.max(x,y),(x,y)=>x+y)
    val tuples = value.collect()
    for(i<-tuples)
    {
      println(i._1+":"+i._2)
    }
    sc.stop()
  }
}
