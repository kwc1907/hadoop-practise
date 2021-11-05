package first

class student(var name:String,var age:Int) {
  val score:Double=2.5
  def printinfo():Unit={
    println(score+" "+name+"  "+age+"  "+student.school)
  }

}

object student{
  val school:String = "shenyang"
  def main(args:Array[String]):Unit={
    val atu =new student("ddd",25)
    atu printinfo()
  }
}
