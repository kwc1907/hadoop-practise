package second

import scala.beans.BeanProperty

object duixiang {
  def main(args: Array[String]): Unit = {
    val a=new student("ll",47)
    a.show
    new kwc("csdv",25).show
  }
}

class student(var name:String){
  var age=0
  @BeanProperty
  var sex=""
  def this(name:String,age:Int)
    {
      this(name)
      this.age=age
    }
  def this(name:String,age:Int,sex:String)
  {
    this(name,age)
    this.sex=sex
  }
  def show=println(s"name:${name},age:$age")
}

class kwc(name:String,age:Int) extends student(name)
{
  var oo=""
  def this(name:String,age:Int,oo:String)
    {
      this(name,age)
      this.oo=oo
    }
}

