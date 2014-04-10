import org.scalatest.{ FunSuite, Matchers }
import org.dupontmanual.image._

object WishLists {
  sealed abstract class ListOf[+X] {
    def head: X
    def tail: ListOf[X]
    
    def abbr: String = {
      def toList(listOf: ListOf[X]): List[X] = listOf match {
        case Empty => Nil
        case Cons(h, t) => h :: toList(t)
      }
      val str: String = toList(this).mkString(", ")
      s"ListOf($str)"
    }
  }
  object ListOf {
    def apply[X](xs: X*): ListOf[X] = {
      xs.toList match {
        case Nil => Empty
        case x :: rest => Cons(x, ListOf(rest: _*))
      }
    }
  }
  case object Empty extends ListOf[Nothing] {
    def head: Nothing = throw new Exception("can't take head of Empty")
    def tail: ListOf[Nothing] = throw new Exception("can't take tail of Empty")
  }
  case class Cons[X](head: X, tail: ListOf[X]) extends ListOf[X]
  
  /** given a ListOf[X], produces ...
  def listOfXFun(listOfX: ListOf[X]): ??? = {
    listOfX match {
      case Empty => ???
      case Cons(head, tail) => head  listOfXFun(tail)
    }
  } */
  
  
}

class TestWishLists extends FunSuite with Matchers {
  import WishLists._

}
