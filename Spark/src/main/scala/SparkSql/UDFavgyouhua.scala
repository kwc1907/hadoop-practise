package SparkSql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Encoder, Encoders, Row, SparkSession, functions}
import org.apache.spark.sql.expressions.{Aggregator, MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, LongType, StructField, StructType}

object UDFavgyouhua {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("udf")
    val spark=SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._
    val rdd = spark.sparkContext.makeRDD(List((0, "kwc", 14, 96l), (1, "xiaohei", 58, 78l), (2, "xiaohong", 47, 66l), (3, "xiaolizi", 36, 95l), (4, "paohui", 88, 55l)))
    val df = rdd.toDF("id", "name", "age", "score")
    df.createOrReplaceTempView("person")
    spark.udf.register("myavg",functions.udaf(new avgeUdf()))
    spark.sql("select myavg(age) from person").show()
    spark.close()
  }
  case class Buff(var total:Int,var count:Long)
  class avgeUdf extends Aggregator[Int,Buff,Long]{
    //缓冲区初始化
    override def zero: Buff = {
    Buff(0,0l)
    }
    //更新缓冲区数据
    override def reduce(b: Buff, a: Int): Buff = {
    b.total=b.total+a
    b.count=b.count+1
      b
    }
    //合并缓冲区
    override def merge(b1: Buff, b2: Buff): Buff = {
      b1.total=b1.total+b2.total
      b1.count=b1.count+b2.count
    b1
    }
//计算
    override def finish(reduction: Buff): Long = {
    reduction.total/reduction.count
    }
//缓冲区的编码操作                         根据这的值，自定义product
    override def bufferEncoder: Encoder[Buff] = Encoders.product

    override def outputEncoder: Encoder[Long] = Encoders.scalaLong
  }
}
