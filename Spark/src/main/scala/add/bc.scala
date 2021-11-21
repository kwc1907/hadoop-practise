package add

import org.apache.spark.{SparkConf, SparkContext}

object bc {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd1=sc.makeRDD(List(("a",5),("b",6),("c",8),("d",85)))
    val value = sc.broadcast(Map(("a", 56), ("b", 2), ("c", 4), ("d", 5)))
    rdd1.map{
      case(w,c)=>{
        val i = value.value.getOrElse(w, 0)
        i
      }
    }
    sc.stop()
  }
}
