package review

import org.apache.spark.sql.SparkSession
import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

object first {
  def main(args:Array[String]):Unit={
    val conf=new SparkConf().setMaster("local[*]").setAppName("first_review")
    val spark=SparkSession.builder().enableHiveSupport().config(conf).getOrCreate()
    spark.close()
  }

}
