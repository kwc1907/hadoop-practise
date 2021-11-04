package second

object zuanshiques {
  def main(args: Array[String]): Unit = {
  var a=new suiyi()
    println(a.des())
  }
}

trait ball
{
  def des()="ball"
}

trait colorball extends ball
{
  var color="red"

  override def des(): String = color+":"+super.des()
}

trait cateball extends ball
{
  var cat="football"

  override def des(): String = cat+":"+super.des()
}

class suiyi extends cateball with colorball
{
  override def des(): String = "my ball is "+super[cateball].des()
}

