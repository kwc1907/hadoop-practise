package transform_suanzi

import org.apache.spark.{SparkConf, SparkContext}

object value_groupby {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.makeRDD(List(14,25,36,52,55),2)
    val rddgroup = rdd.groupBy(i => i % 2)
    val tuples = rddgroup.collect()
    for(i<-tuples)
      {
        println(i._1+" "+i._2.mkString(","))
      }
  }
}
