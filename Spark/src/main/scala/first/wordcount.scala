package first

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.io.Source

object wordcount {
  def main(args:Array[String]):Unit={
    val conf=new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(conf)
    val line:RDD[String] = sc.textFile("C:\\Users\\若久\\Desktop\\随缘记事本\\新建文件夹")
    val words:RDD[String] = line.flatMap(x => x.split(" "))
    val wordGroup= words.groupBy(i => i)
    val wordcount=wordGroup.map(i=>(i._1,i._2.size))
    val tuples = wordcount.collect()
    for(i <- tuples)
    {
      println(i._1+":"+i._2)
    }
    sc.stop()
  }
}
