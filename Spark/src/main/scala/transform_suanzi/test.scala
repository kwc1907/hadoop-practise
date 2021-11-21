package transform_suanzi

import org.apache.spark.{SparkConf, SparkContext}

object test {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("test")
    val sc=new SparkContext(conf)
    val rdd = sc.textFile("D:\\Hadoop\\Spark\\2.资料\\data\\agent.log")
    val maprdd = rdd.map(line => {
      val strings = line.split(" ")
      (strings(1)+strings(4), 1)
    })
    val reducemaprdd = maprdd.reduceByKey(_ + _)
    val map2rdd = reducemaprdd.map(i => (i._1.charAt(0), (i._1.substring(1), i._2)))
    val grouprdd = map2rdd.groupByKey()
    val value = grouprdd.mapValues(i => {
      val list = i.toList
      val list1 = list.sortWith((x, y) => x._2 > y._2)
      list1.take(3)
    })
    val tuples = value.collect()
    for(i <-tuples)
      {
        println(i._1+":")
        val o=i._2
        for(j<-o)
          {
            print(j._1+":"+j._2+"\t")
          }
        println()
      }
    sc.stop()
    val l=List(("csdv",14))
  }
}
