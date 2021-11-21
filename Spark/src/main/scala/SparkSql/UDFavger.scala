package SparkSql

import org.apache.parquet.format.IntType
import org.apache.spark.SparkConf
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, LongType, StructField, StructType}

object UDFavger {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("udf")
    val spark=SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._
    val rdd = spark.sparkContext.makeRDD(List((0, "kwc", 14, 96l), (1, "xiaohei", 58, 78l), (2, "xiaohong", 47, 66l), (3, "xiaolizi", 36, 95l), (4, "paohui", 88, 55l)))
    val df = rdd.toDF("id", "name", "age", "score")
    df.createOrReplaceTempView("person")
    spark.udf.register("myavg",new avgUdf())
    spark.sql("select myavg(score) from person").show()
    spark.close()
  }
  class avgUdf extends UserDefinedAggregateFunction{
    override def inputSchema: StructType = StructType(Array(StructField("score",LongType)))

    override def bufferSchema: StructType =StructType(Array(StructField("total",LongType),StructField("count",LongType)))

    override def dataType: DataType = LongType

    override def deterministic: Boolean = true

    override def initialize(buffer: MutableAggregationBuffer): Unit = {
      buffer(0)=0L
      buffer(1)=0L
    }

    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
      buffer.update(0,buffer.getLong(0)+input.getLong(0))
      buffer.update(1,buffer.getLong(1)+1)
    }

    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
      buffer1.update(0,buffer1.getLong(0)+buffer2.getLong(0))
      buffer1.update(1,buffer1.getLong(1)+buffer2.getLong(1))
    }

    override def evaluate(buffer: Row): Any = {
    buffer.getLong(0)/buffer.getLong(1)
    }
  }
}
