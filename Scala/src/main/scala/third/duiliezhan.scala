package third

import scala.collection.mutable

object duiliezhan {
  def main(args: Array[String]): Unit = {
    val queue=new mutable.Queue[String]()
    queue.enqueue("cdf","vfdv","vdfv")
    println(queue.dequeue())
    println(queue)
  }
}
