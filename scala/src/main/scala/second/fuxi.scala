package second

object fuxi {
  def main(args: Array[String]): Unit = {
    val a=new person1("vsdv",14)
    a.show
    val b=new student2("csdv",14,"dsv",89)
     b.show
    val c= new ed
    c.show
  }
}

class person1
{
  private [second] val oo=8
  var name=""
  var age=0
  var sex=""
  def this(name:String,age:Int)
    {
      this()
      this.name=name
      this.age=age
    }
  def this(name:String,age:Int,sex:String)
    {
      this(name,age)
      this.sex=sex
    }
  def show=println(s"name:$name,age:$age,sex:$sex")
}

class student2 extends person1
{
  var score=0
  def this(name:String,age:Int,sex:String,score:Int)
    {
      this()
      this.age=age
      this.name=name
      this.sex=sex
      this.score=score
    }
  override def show={
    super.show
    println(s"score:${score}")
  }
}

abstract class ppp
{
  var b:String
  val a=25
  var c=41
  def show():Unit
}

class ed extends ppp
{
  var b="cdvd"
  def show=println(a+b+c)

  override val a: Int = 85

}