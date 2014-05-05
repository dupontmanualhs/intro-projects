import org.scalatest.{ FunSuite, Matchers }
import scala.language.implicitConversions
import org.dupontmanual.image._

object ListAbbreviations {
  /** STUFF TO TRANSLATE FROM OUR LISTS TO SCALA LISTS **/
  def Cons[X](head: X, tail: List[X]) = head :: tail
  val Empty = Nil
  
  implicit def any2consable(any: Any) = new Consable(any) 
  class Consable(any: Any) {
    def asConsString: String = any match {
      case Nil => "Empty"
      case head :: tail => s"Cons(${head.asConsString}, ${tail.asConsString})"
      case x => x.toString
    }
  }
  
  
  
}

class TestListAbbreviations extends FunSuite with Matchers {
  import ListAbbreviations._

  test("#1") {
    // Re-write each list using Cons and Empty, not List
    List(0, 1, 2, 3, 4, 5) shouldEqual Empty
    List(List("Adam", 0), List("Eve", 1), List("Louis XIV", 2)) shouldEqual
        Empty
    List(1, List(1, 2), List(1, 2, 3)) shouldEqual
        Empty
  }
  
  test("#2") {
    // Re-write each list using List, not Cons and Empty
    Cons("a", Cons("b", Cons("c", Cons("d", Cons("e", Empty))))) shouldEqual
        List()
    Cons(Cons(1, Cons(2, Empty)), Empty) shouldEqual List()
    Cons("a", Cons(Cons(1, Empty), Cons(false, Empty))) shouldEqual List()
    Cons(Cons(1, Cons(2, Empty)), Cons(Cons(2, Cons(3, Empty)), Empty)) shouldEqual 
        List()
  }
  
  test("#3") {
    // You can use Cons, List, and Empty together, but it's usually pretty confusing
    // Re-write these using only Cons and Empty
    Cons("a", List(0, false)) shouldEqual Empty
    List(Cons(1, Cons(13, Empty))) shouldEqual Empty
    List(Empty, Empty, Cons(1, Empty)) shouldEqual Empty
    Cons("a", Cons(List(1), List(false, Empty))) shouldEqual Empty
  }
  
  test("#4") {
    // You can use Cons, List, and Empty together, but it's usually pretty confusing
    // Re-write these using only List, not Cons and Empty
    Cons("a", List(0, false)) shouldEqual List()
    List(Cons(1, Cons(13, Empty))) shouldEqual List()
    List(Empty, Empty, Cons(1, Empty)) shouldEqual List()
    Cons("a", Cons(List(1), List(false, Empty))) shouldEqual List()
  }
  
  test("#5") {
    // Simplify each expression as much as possible and write each using only Cons
    // and Empty
    List("a" == "b", "c" == "c", false) shouldEqual Empty
    List(10 + 20, 10 * 20, 20 / 10) shouldEqual Empty
    Cons("Dana", List("Jane", "Mary")) shouldEqual Empty
  }
  
  test("#6") {
    // Simplify each expression as much as possible. Use List to write any lists.
    List(1, 2, 3).head shouldEqual List()
    List(1, 2, 3).tail shouldEqual List()
    Cons(Cons(4, Cons(2, Empty)), Cons(3, Empty)).head shouldEqual List()
    List(4).tail shouldEqual List()
    List(3, 4, 5).tail.head shouldEqual List()
  }
  
}
