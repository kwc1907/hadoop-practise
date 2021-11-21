package SparkSql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object JDBC {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("udf")
    val spark=SparkSession.builder().config(conf).getOrCreate()
    val df=spark.read.format("jdbc")
      .option("url", "jdbc:mysql://localhost:3306/lian")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "root")
      .option("password", "190713")
      .option("dbtable", "user")
      .load()
    df.write.format("jdbc")
      .option("url", "jdbc:mysql://localhost:3306/lian")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "root")
      .option("password", "190713")
      .option("dbtable", "user1")
        .save()
    spark.close()
  }
}
