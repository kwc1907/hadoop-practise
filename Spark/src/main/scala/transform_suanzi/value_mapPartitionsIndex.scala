package transform_suanzi

import org.apache.spark.{SparkConf, SparkContext}

object value_mapPartitionsIndex {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.makeRDD(List(14,25,36,58),2)
    val rddmap = rdd.mapPartitionsWithIndex((i,j)=>{
      println("sssssssssssssss")
      j.map(k=>(i,k))
    })
    rddmap.collect().foreach(println)
  }
}
