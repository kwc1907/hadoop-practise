package second

object tezhi {
  def main(args: Array[String]): Unit = {
    var a=new student3()
    a.study
    a.yuehui
    a.play
    a.learn
    def b=new student3 with talent{
      override def sing(): Unit = println(s"$name singiing")
    }
    b.sing()
  }
}

class rr
{
  val name="ddddddd"
println("vdvdfv")
}

trait qwe
{
  var age:Int
  val name="yong"
  def play=println(s"${name}playing")
  def yuehui:Unit
  println("ffffffffffffff")
}
trait know
{
  var knowname:String
  def learn():Unit
}
trait talent
{
  def sing():Unit
}
class student3 extends rr with qwe with know
{
  override val name: String = "ttttttt"
  var age=58
  def yuehui=println(s"$name yuehui")
  def study=println(s"$name dfvd")

  override var knowname: String = "yuwen"
  def learn=println(s"$name xuexi $knowname")
}
