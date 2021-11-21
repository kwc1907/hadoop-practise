package spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.DStream

import scala.collection.mutable







object queue {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("queue")
    val ssc=new StreamingContext(conf,Seconds(3))
    val rddqueue=new mutable.Queue[RDD[Int]]()
    val inputStream = ssc.queueStream(rddqueue, oneAtATime = false)
    val value = inputStream.map((_, 1))
    val value1 = value.reduceByKey(_ + _)
    value1.print()
    ssc.start()
    for(i <- 0 until 5)
      {
        rddqueue+= ssc.sparkContext.makeRDD(List(41,25,3,62,58,5),10)
        Thread.sleep(2000)
      }
    ssc.awaitTermination()
  }
}
