package first

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object wordcount2 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("wordCount2")
    val sc = new SparkContext(conf)

    val line:RDD[String] = sc.textFile("C:\\Users\\若久\\Desktop\\随缘记事本\\新建文件夹")
    val words = line.flatMap(_.split(" "))
    val wordToOne = words.map(i=>(i,1))
    val wordtoGrounp = wordToOne.groupBy(i => i._1)
    val value = wordtoGrounp.map(i => (i._2.reduce((x, y) => (x._1,x._2 + y._2))))
    val tuples:Array[(String,Int)] = value.collect()
    for(i <- tuples)
    {
      println(i._1+":"+i._2)
    }
    sc.stop()
  }
}
