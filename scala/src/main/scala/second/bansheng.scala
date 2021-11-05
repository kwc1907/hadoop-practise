package second

object bansheng {
  def main(args: Array[String]): Unit = {
    val a=student1.createStudent("csdv")
    a.show()
  }
}

class student1 private(val name:String)
{
  var age:Int=0
  def this(name:String,age:Int)
    {
      this(name)
      this.age=age
    }
  def show()=println(s"name:${name},age:$age,school:${student1.school}")
}
object student1
{
  val school="sdvdsvd"
  def createStudent(name:String):student1={return new student1("sdvdv")}
}
