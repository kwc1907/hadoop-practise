package part

import org.apache.spark.{Partitioner, SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object rdd_part {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.makeRDD(List(("nba", "zzzzz"), ("cba", "csdfdrg"), ("lba", "tttttttttttt"), ("uba", "ggggggggggggg"),("nba", "zbdfdhbszvsv")))
    val rddpart = rdd.partitionBy(new myPartition(3))
    rddpart.saveAsTextFile("C:\\Users\\若久\\Desktop\\随缘记事本\\ll")
    sc.stop()
  }
  class myPartition(number:Int) extends Partitioner{
    override def numPartitions: Int = number

    override def getPartition(key: Any): Int = {
     key match {
       case "nba" => 0
       case "cba" => 1
       case _ => 2
     }
    }
  }
}
