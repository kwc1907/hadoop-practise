package second

object abstr {
  def main(args: Array[String]): Unit = {
    val a=new person {
       var name: String = "cdvdfv"
       def eat = println("vdvdfb")
    }
    a.eat
  }
}

abstract class Person{
  val name="kwc"
  var age:Int
  val sex:String
  def eat=println("吃")
  def sleep():Unit
}

class studen extends Person
{
  val sex=""
  var age=56

  override val name="cdvdf"
  def sleep(): Unit = println("sleep")
}
abstract class person{
  var name:String
  def eat():Unit
}