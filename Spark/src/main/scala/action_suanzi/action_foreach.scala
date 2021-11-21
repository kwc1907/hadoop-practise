package action_suanzi

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object action_foreach {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("suanzi")
    val sc =new SparkContext(conf)
    val rdd=sc.makeRDD(List(new person14(14),new person14(25),new person14(36)))
    rdd.cache()
    val value = rdd.map(_.number)
    println(value.reduce(_+_))
    sc.stop()
  }
}

class person14(val number:Int) extends Serializable
{

}