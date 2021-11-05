package first

class review(var name:String,var age:Int){
  var school: String = "shney"
    val ch:String=school
    var ff="csdfc"
    ff="sdfds"
    school="ddfd"
    def show():Unit={
      println(name+"  "+age+"  "+school+"  "+ch)
    }
}

object review{

  def main(args:Array[String]):Unit={
    val asd=new review("kwc",21)
    val qwe=asd
    qwe.name="cfsfd"
    asd.show()
    qwe.show()
  }

}
