package transform_suanzi

import org.apache.spark.{SparkConf, SparkContext}

object value_map_par {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.makeRDD(List(41,2,5,3,55,74),1)
    val maprdd = rdd.map(i => {println(s"i:$i");i})
    val maprdd1 = maprdd.map(i => {println(s"i1:$i");i})
    maprdd1.collect()
  }
}
