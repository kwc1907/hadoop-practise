package SparkSql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object sparksql_basic {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("sparkSql")
    val spark=SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._
    val df = spark.read.json("C:\\Users\\若久\\Desktop\\随缘记事本\\新建文件夹\\3.json")
    //df.createOrReplaceTempView("user")
    //spark.sql("select *from user").show()
    //df.filter($"age" >20).select("username").show()
    val seq=Seq(12,25,36,82)
    val ds= seq.toDS()
    //ds.show()
    val rdd = spark.sparkContext.makeRDD(List((1, "kwc", 25), (2, "sb", 36), (3, "xiaohong", 47)))
    val df1 = rdd.toDF("id", "name", "age")
    val rdd1=df1.rdd
    val rows = rdd1.collect()
    rows.foreach(println)
    df1.show()
    val ds1 = df1.as[person]
    ds1.show()
    val rddmap = rdd.map {
      case (id, name, age) => person(id, name, age)
    }
    rddmap.toDS().show()
    spark.close()
  }
case class person(id:Int,name:String,age:Int)
}
