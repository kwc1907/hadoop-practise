package add

import org.apache.spark.{SparkConf, SparkContext}
import part.rdd_part.myPartition

object Acc {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd = sc.makeRDD(List(1, 2, 3, 4))
    val sumacc = sc.longAccumulator("sum")
    rdd.foreach(i=>
    sumacc.add(i))
    println(sumacc.value)
    sc.stop()
  }
}
