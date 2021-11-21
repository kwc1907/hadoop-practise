package rdd

import org.apache.spark.{SparkConf, SparkContext}

object rdd_file_par {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("rdd")  //local[*] *代表你电脑的核数，16核开16个线程
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("C:\\Users\\若久\\Desktop\\随缘记事本\\新建文件夹\\1.txt",3)
    rdd.saveAsTextFile("C:\\Users\\若久\\Desktop\\随缘记事本\\output")
    rdd.collect().foreach(println)
    sc.stop()
  }
}
