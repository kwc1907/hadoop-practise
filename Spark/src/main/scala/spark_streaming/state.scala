package spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object state {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("sparkStreaming")
    val ssc=new StreamingContext(conf,Seconds(3))
    ssc.checkpoint("ll")
    val dstream = ssc.socketTextStream("localhost", 9999)
    val value = dstream.flatMap(_.split(" ")).map((_,1))
    val state = value.updateStateByKey(
      (seq: Seq[Int], buff: Option[Int]) => {
        val newc = buff.getOrElse(0) + seq.sum
        Option(newc)
      }
    )
    state.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
