package spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object transform {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("sparkStreaming")
    val ssc=new StreamingContext(conf,Seconds(3))
    val dstream=ssc.socketTextStream("localhost",9999)
    val value = dstream.transform(rdd => rdd)
    ssc.start()
    ssc.awaitTermination()
  }
}
