package example

import org.apache.spark.{SparkConf, SparkContext}

object sessiontongji {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("heji")
    val sc = new SparkContext(conf)
    val rdd=sc.textFile("D:\\Hadoop\\Spark\\2.资料\\spark-core数据\\user_visit_action.txt")
    val rddmap=rdd.map(i=>{
                            val datas = i.split("_")
                            UserVisitAction(
                              datas(0),
                              datas(1).toLong,
                              datas(2),
                              datas(3).toLong,
                              datas(4),
                              datas(5),
                              datas(6).toLong,
                              datas(7).toLong,
                              datas(8),
                              datas(9),
                              datas(10),
                              datas(11),
                              datas(12).toLong
                            )
    })
    val rddgroup = rddmap.groupBy(_.session_id)
    val value = rddgroup.mapValues(i => {
      val actions = i.toList.sortBy(_.action_time)
      val u=actions.map(i=>{
        if(i.search_keyword!="null")
          i.page_id.toString+"(搜索)"
        else if(i.click_category_id.toString!="-1")
          i.page_id.toString+"(点击页面)"
        else if(i.order_category_ids!="null")
          i.page_id.toString+"(订单页面)"
        else if(i.pay_category_ids!="null")
          i.page_id.toString+"(支付页面)"
        else
          i.page_id.toString
      })
      val str = u.reduce((x, y) => {
        x + "-" + y
      })
      str
    })
    val tuples = value.collect()
    for(i <- tuples)
      {
        println(i._1+":"+i._2)
      }
    sc.stop()
  }
  case class UserVisitAction(
                              date: String,//用户点击行为的日期
                              user_id: Long,//用户的 ID
                              session_id: String,//Session 的 ID
                              page_id: Long,//某个页面的 ID
                              action_time: String,//动作的时间点
                              search_keyword: String,//用户搜索的关键词
                              click_category_id: Long,//某一个商品品类的 ID
                              click_product_id: Long,//某一个商品的 ID
                              order_category_ids: String,//一次订单中所有品类的 ID 集合
                              order_product_ids: String,//一次订单中所有商品的 ID 集合
                              pay_category_ids: String,//一次支付中所有品类的 ID 集合
                              pay_product_ids: String,//一次支付中所有商品的 ID 集合
                              city_id: Long
                            )//城市 id
}
