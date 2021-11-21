package distribute_test

import java.io.ObjectOutputStream
import java.net.Socket

object Driver {
  def main(args: Array[String]): Unit = {
    val client =new Socket("localhost",9999)
    val out = client.getOutputStream
    val objectOutputStream = new ObjectOutputStream(out)
    val task=new Task()
    objectOutputStream.writeObject(task)
    out.flush()
    out.close()
    client.close()
    println("数据传输成功")
  }

}
