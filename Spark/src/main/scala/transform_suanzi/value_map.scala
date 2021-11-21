package transform_suanzi

import org.apache.spark.{SparkConf, SparkContext}

object value_map {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.textFile("D:\\Hadoop\\Spark\\2.资料\\data\\apache.log")
    val maprdd = rdd.map(
      i=>{
        val t=i.split(" ")
        t(6)}
    )
    maprdd.collect().foreach(println)
  }
}
