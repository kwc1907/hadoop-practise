package distribute_test

import java.io.ObjectInputStream
import java.net.ServerSocket

object Executor {
  def main(args: Array[String]): Unit = {
    val server = new ServerSocket(9999)
    println("服务器启动")
    val socket = server.accept()
    val stream = socket.getInputStream
    val objectInputStream = new ObjectInputStream(stream)
    val i = objectInputStream.readObject().asInstanceOf[Task]
    val ints = i.jisuan()
    println(ints.mkString(","))
    stream.close()
    socket.close()
    server.close()
  }
}
