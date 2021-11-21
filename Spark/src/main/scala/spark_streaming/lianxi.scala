package spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext, StreamingContextState}
import org.apache.spark.streaming.dstream.DStream

object lianxi {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("sparkStreaming")
    val ssc=new StreamingContext(conf,Seconds(3))

    ssc.start()
    new Thread(
      new Runnable {
        override def run(): Unit = {
          while(true)
            {if(true)
            {
              val state=ssc.getState()
              if(state==StreamingContextState.ACTIVE){
                ssc.stop(true,true)}
            }
            Thread.sleep(5000)
            }

        }
      }
    ).start()
    ssc.awaitTermination()
  }

}
