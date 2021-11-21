package spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.util.Random

object review {
  def main(args:Array[String]):Unit={
    val conf=new SparkConf().setMaster("local[*]").setAppName("ll")
    val ssc=new StreamingContext(conf,Seconds(3))
    val value = ssc.receiverStream(new myre())
    value.print()
    ssc.start()
    ssc.awaitTermination()
  }
  class myre extends Receiver[String](StorageLevel.MEMORY_ONLY){
    private var flag=true
    override def onStart(): Unit = {
      new Thread(
        new Runnable {
          override def run(): Unit = {
          while(flag)
            {
              store("采集的数据为："+new Random().nextInt(10).toString)
              Thread.sleep(1000)
            }
          }
        }
      ).start()
    }

    override def onStop(): Unit = {
    flag=false
    }
  }
}
