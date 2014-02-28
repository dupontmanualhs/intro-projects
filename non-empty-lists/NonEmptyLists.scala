import org.scalatest.{ FunSuite, Matchers }
import org.dupontmanual.image._

object NonEmptyLists {
  sealed abstract class ListOf[+X] {
    def head: X
    def tail: ListOf[X]
  }
  case object Empty extends ListOf[Nothing] {
    def head: Nothing = throw new Exception("can't take head of Empty")
    def tail: ListOf[Nothing] = throw new Exception("can't take tail of Empty")
  }
  case class Cons[X](head: X, tail: ListOf[X]) extends ListOf[X]
  
  /** given a ListOf[X], produces ...
  def listOfXFun(listOfX: ListOf[X]): ??? = {
    listOfX match {
      case Empty() => ???
      case Cons(head, tail) => head  listOfXFun(tail)
    }
  } */
  
  type NonEmptyListOf[X] = Cons[X]
  
  /** given a NonEmptyListOf[X], produces ...
  def neloxFun(nelox: NonEmptyListOf[X]): ??? = {
    nelox match {
      case Cons(head, Empty) => 
      case Cons(head, tail) => 
    }
  } */
  
  /** given a non-empty list of numbers, produces the product */
  def product(nums: NonEmptyListOf[Double]): Double = {
    nums match {
      case Cons(head, Empty) => head
      case Cons(head, tail: NonEmptyListOf[Double]) => head * product(tail)
    }
  }
  
  /** given a list of at least 2 X's, produces ???
  def loal2xFun(loal2x: ListOf[X]): ??? = {
    loal2x match {
      case Cons(one, Cons(two, Empty)) => one  two
      case Cons(one, Cons(two, tail: NonEmptyListOf[X])) => one  two  loal2xFun(Cons(two, tail))
      case _ => throw new Exception("must have at least two values in the list")
    }
  } */
}

class TestNonEmptyLists extends FunSuite with Matchers {
  import NonEmptyLists._

  test("product") {
    product(Cons(1, Empty)) shouldBe 1
    product(Cons(3, Cons(4, Cons(2, Empty)))) shouldBe 24
  }
}
