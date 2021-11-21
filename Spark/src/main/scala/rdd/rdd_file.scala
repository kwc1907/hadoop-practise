package rdd

import org.apache.spark.{SparkConf, SparkContext}

object rdd_file {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("rdd")  //local[*] *代表你电脑的核数，16核开16个线程
    val sc = new SparkContext(conf)
    //val rdd = sc.textFile("C:\\Users\\若久\\Desktop\\随缘记事本\\新建文件夹")
    val rdd=sc.wholeTextFiles("C:\\Users\\若久\\Desktop\\随缘记事本\\新建文件夹")
    rdd.collect().foreach(println)
    sc.stop()
  }
}
