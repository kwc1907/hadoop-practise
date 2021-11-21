package SparkSql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object hive {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("uf")
    val spark=SparkSession.builder().enableHiveSupport().config(conf).getOrCreate()
    spark.close()
  }
}
