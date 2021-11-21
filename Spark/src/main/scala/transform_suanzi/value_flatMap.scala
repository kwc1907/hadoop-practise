package transform_suanzi

import org.apache.spark.{SparkConf, SparkContext}

object value_flatMap {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.makeRDD(List("csdv vdv vefv","csdv csdv vdv"))
    val rddflatmap = rdd.flatMap(i => {
      i.split(" ")
    })
    rddflatmap.collect().foreach(println)
  }
}
