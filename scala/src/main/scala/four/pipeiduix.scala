package four

object pipeiduix {
  def main(args: Array[String]): Unit = {
    val a=new student14("kwc",58)
    a match {
      case student14("kwc",58) => println("success")
      case _=> println("shibai")
    }

  }
}

class student14(val name:String,val age:Int)
{

}

object student14{
  def apply(name: String, age: Int): student14 = new student14(name, age)

  def unapply(arg: student14): Option[(String, Int)] = {
  if (arg == null)
    {
      return None
    }
    else
  {
    Some(arg.name,arg.age)
  }
  }
}