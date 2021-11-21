package distribute_test

class Task extends Serializable {
  var datas = List(14,25,36,41)
  val logic = (i:Int)=> i*2
  def jisuan()={
    datas.map(logic)
  }
}
