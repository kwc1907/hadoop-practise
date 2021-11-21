package example

import add.heji.myAccumulator
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

object topten {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("heji")
    val sc = new SparkContext(conf)
    val rdd=sc.textFile("D:\\Hadoop\\Spark\\2.资料\\spark-core数据\\user_visit_action.txt")
    val rddfilter=rdd.filter(i=>{
      val strings = i.split("_")
      strings(6)!="-1"
    })
    val rddreduceby=rddfilter.map(i=>
      {
        val strings = i.split("_")
        (strings(6)+" "+strings(7),1)
      }
    ).reduceByKey(_ + _)
    val rddgroup = rddreduceby.map(i => {
      val strings = i._1.split(" ")
      (strings(0), (strings(1), i._2))
    }).groupByKey()
    val value = rddgroup.mapValues(i => {
      val list = i.toList
      list.sortBy(_._2)(Ordering[Int].reverse).take(10)
    })
    val tuples = value.collect()
    for(i <- tuples)
      {
        println(i._1+":")
        for(j <- i._2)
          {
            print("("+j._1+","+j._2+")"+"\t")
          }
        println()
      }
    sc.stop()
  }
}
