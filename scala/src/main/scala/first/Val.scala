package first

object Val {
  def main(args:Array[String]):Unit={
    val name:String = "kwc"
    val age=25.33651
    println(name*3)
    printf("年龄是%.3f，名字是%s\n",age,name)
    println(s"年龄是${age}，名字是${name}")
    println(f"年龄是${age}%.2f,名字是${name}")
    println(raw"f年龄是${age}%.2f,名字是${name}")
    val sql =s"""
       |select
       |* from student
       |where
       |""".stripMargin
    println(sql)
  }
}
