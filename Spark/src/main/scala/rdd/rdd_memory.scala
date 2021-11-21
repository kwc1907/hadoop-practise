package rdd

import org.apache.spark.{SparkConf, SparkContext}

object rdd_memory {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("rdd")  //local[*] *代表你电脑的核数，16核开16个线程
    val sc = new SparkContext(conf)
    val seq = Seq(14, 25, 36, 14)
    //val rdd = sc.parallelize(seq)
    val rdd=sc.makeRDD(seq)
    val maprdd = rdd.map(_ * 2)
    maprdd.collect().foreach(println)
    sc.stop()
  }
}
