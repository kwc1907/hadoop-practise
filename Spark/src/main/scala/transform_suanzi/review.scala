package transform_suanzi

import org.apache.spark.{SparkConf, SparkContext}

object review {
  def main(args:Array[String]):Unit={
    val conf = new SparkConf().setMaster("local[*]").setAppName("fuxi")
    val sc = new SparkContext(conf)
    val rdd=sc.textFile("D:\\Hadoop\\Spark\\2.资料\\data\\agent.log")
    val rddmap = rdd.map(i => {
      val strings = i.split(" ")
      (strings(1)+" "+strings(4),1)
    })
    val value = rddmap.reduceByKey(_ + _)
    val value1 = value.map(i => {
      val strings = i._1.split(" ")
      (strings(0), (strings(1), i._2))
    })
    val value2 = value1.groupByKey()
    val value3 = value2.map(i => {
      val list = i._2.toList
      val tuples = list.sortWith((x, y) => x._2 > y._2)
      (i._1, tuples.take(3))
    })
    val tuples = value3.collect()
    for(i<-tuples)
      {
        println(i._1+":")
        for(j<-i._2)
        {print(j._1+":"+j._2+"\t")
        }
        println()
      }

    sc.stop()
  }
}
