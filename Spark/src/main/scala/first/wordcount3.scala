package first

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object wordcount3 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("wordCount3")
    val sc = new SparkContext(conf)
    val line:RDD[String] = sc.textFile("C:\\Users\\若久\\Desktop\\随缘记事本\\新建文件夹\\2.txt")
    val words = line.flatMap(_.split(" "))
    val wordToOne = words.map(i=>(i,1))
    val w = wordToOne.reduceByKey(_ + _)
    val tuples = w.collect()
    for(i <- tuples)
    {
      println(i._1+":"+i._2)
    }
    sc.stop()
  }
}
