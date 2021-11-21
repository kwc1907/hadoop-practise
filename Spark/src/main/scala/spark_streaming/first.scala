package spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object first {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("sparkStreaming")
    val ssc=new StreamingContext(conf,Seconds(3))
    val lines = ssc.socketTextStream("localhost", 9999)
    val words:DStream[String]= lines.flatMap(_.split(" "))
    val dstream = words.map((_, 1))
    val dstreamreduce = dstream.reduceByKey(_ + _)
    dstreamreduce.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
