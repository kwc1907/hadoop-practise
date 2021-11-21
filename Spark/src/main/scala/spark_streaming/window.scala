package spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object window {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("sparkStreaming")
    val ssc=new StreamingContext(conf,Seconds(3))
    val dstream=ssc.socketTextStream("localhost",9999)
    val wordone = dstream.map((_, 1))
    val windowds = wordone.window(Seconds(6))
    val reduceds = windowds.reduceByKey(_ + _)
    reduceds.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
