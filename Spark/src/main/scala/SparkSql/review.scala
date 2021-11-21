package SparkSql

import org.apache.spark.SparkConf
import org.apache.spark.sql.expressions.Aggregator
import org.apache.spark.sql.{Encoder, Encoders, SparkSession, functions}

object review {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[*]").setAppName("review")
    val spark=SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._
    val rdd=spark.sparkContext.makeRDD(List((1,"kwc",25),(2,"lisi",30),(3,"wangwu",88)))
    val df=rdd.toDF("id","name","age")
    df.select("id","age").show()
    df.createOrReplaceTempView("person")
    val maprdd = rdd.map {
      case (id, name, age) => person(id, name, age)
    }
    spark.udf.register("myavg",functions.udaf(new myavg()))
    spark.sql("select myavg(age) as avg_age from person").show()
    val ds = maprdd.toDS()
    ds.show()
  }
  case class person(id:Int,name:String,age:Int)
  case class Buff(var total:Int,var count:Long)
  class myavg extends Aggregator[Int,Buff,Long]
  {
    override def zero: Buff ={
      Buff(0,0l)
    }

    override def reduce(b: Buff, a: Int): Buff = {
    b.total=b.total+a
      b.count=b.count+1
      b
    }

    override def merge(b1: Buff, b2: Buff): Buff = {
      b1.count=b1.count+b2.count
      b1.total=b1.total+b2.total
      b1
    }


    override def finish(reduction: Buff): Long = {
      reduction.total/reduction.count
    }

    override def bufferEncoder: Encoder[Buff] = Encoders.product

    override def outputEncoder: Encoder[Long] = Encoders.scalaLong
  }
}
