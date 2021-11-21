package SparkSql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object UDF {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("udf")
    val spark=SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._
    val rdd = spark.sparkContext.makeRDD(List((0, "kwc", 14, 96), (1, "xiaohei", 58, 78), (2, "xiaohong", 47, 66), (3, "xiaolizi", 36, 95), (4, "paohui", 88, 55)))
    val df = rdd.toDF("id", "name", "age", "score")
    df.createOrReplaceTempView("person")
    spark.udf.register("prefixname",(i:String)=>"vdv"+i)
    //spark.sql("select prefixname(name),age from person").show()

    spark.close()
  }
  case class person(id:Int,name:String,age:Int,score:Int)
}
