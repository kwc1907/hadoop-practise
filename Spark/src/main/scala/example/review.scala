package example

import org.apache.spark.{SparkConf, SparkContext}

object review {
  def main(args:Array[String]):Unit={
    val conf=new SparkConf().setMaster("local[8]").setAppName("sdv")
    val sc=new SparkContext(conf)
    val rdd = sc.makeRDD(List("csdv vdv vefv","csdv csdv vdv"))
    rdd.saveAsTextFile("C:\\Users\\若久\\Desktop\\随缘记事本\\l")
    sc.stop()

  }
}
