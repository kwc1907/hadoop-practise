package transform_suanzi

import org.apache.spark.{SparkConf, SparkContext}

object value_glom {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.makeRDD(List(14,25,36,52))
    val rddglom=rdd.glom()
    val array = rddglom.collect()
    for(i<-array)
      {
        println(i.mkString(","))
      }
  }

}
