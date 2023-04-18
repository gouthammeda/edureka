package oops.classes

//getters and setters in java, but scala creates them by default.
// public class Duck {
// 	private int size;
// 	public int getSize(){return size;}
// 	public void setSize(int size){
// 		(if size > 0) this.size = size
// 	}
// }

//getters are used to get the value of variable and setters are used to set the value of variable.
class DuckGetterSetter {
  var size = 1
}

object Duckrun {
  def main(args:Array[ String]) {
    var f = new DuckGetterSetter
    f.size = 10
    f.size_=(10)
    println(f.size)
    //f.size=10 or f.size_
    println("----")
  }
}