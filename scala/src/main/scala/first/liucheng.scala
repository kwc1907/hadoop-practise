package first

import scala.io.StdIn
import scala.util.control.Breaks

object liucheng {
  def main(args: Array[String]): Unit = {
    Breaks.breakable(
      for(i <- 1 to 10)
        {
          if(i==5)
            Breaks.break()
          println(i)
        }
    )
  }
}
