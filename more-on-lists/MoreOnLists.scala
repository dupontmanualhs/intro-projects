import org.scalatest.{ FunSuite, Matchers }
import org.dupontmanual.image._

object MoreOnLists {
  sealed abstract class ListOf[X] {
    def head: X
    def tail: ListOf[X]
  }
  case class Empty[X]() extends ListOf[X] {
    def head: X = throw new Exception("can't take head of Empty")
    def tail: ListOf[X] = throw new Exception("can't take tail of Empty")
  }
  case class Cons[X](head: X, tail: ListOf[X]) extends ListOf[X]
  
  /** given a ListOf[X], produces ...
  def listOfXFun(listOfX: ListOf[X]): ??? = {
    listOfX match {
      case Empty() => ???
      case Cons(head, tail) => head  listOfXFun(tail)
    }
  } */
  
  /** given a list of toys, produces whether or not it contains "doll" */
  def containsDoll(toys: ListOf[String]): Boolean = {
    toys match {
      case Empty() => false
      case Cons(head, tail) => head == "doll" ||  containsDoll(tail)
    }
  }
  
  /** given a ListOf[Double], produces a new list with each number doubled */
  def double(nums: ListOf[Double]): ListOf[Double] = {
    nums match {
      case Empty() => Empty()
      case Cons(head, tail) => Cons(2 * head, double(tail))
    }
  }
}

class TestIntroToLists extends FunSuite with Matchers {
  import MoreOnLists._

  test("containsDoll") {
    containsDoll(Empty()) shouldEqual false
    containsDoll(Cons("yo-yo", Cons("bike", Cons("hula hoop",
                   Cons("doll", Empty()))))) shouldEqual true
    containsDoll(Cons("yo-yo", Cons("bike", Cons("hula hoop",
                   Empty())))) shouldEqual false
  }
  
  test("double") {
    double(Empty()) shouldEqual Empty()
    double(Cons(2.0, Empty())) shouldEqual Cons(4.0, Empty())
    double(Cons(2.0, Cons(-3.0, Cons(1.7, Empty())))) shouldEqual
        Cons(4.0, Cons(-6.0, Cons(3.4, Empty())))
  }
  
  test("contains") {
    contains(Empty(), "whatever") shouldEqual false
    contains(Cons("yo-yo", Cons("bike", Cons("hula hoop",
                   Cons("doll", Empty())))), "bike") shouldEqual true
    contains(Cons("yo-yo", Cons("bike", Cons("hula hoop",
                   Cons("doll", Empty())))), "jacks") shouldEqual false
    // add your own test cases here
  }
  
  test("multiplyBy") {
    multiplyBy(Empty(), 5.0) shouldEqual Empty()
    multiplyBy(Cons(2.0, Cons(1.5, Cons(4.5, Empty()))), 3.0) shouldEqual
        Cons(6.0, Cons(4.5, Cons(13.5, Empty())))
    // add your own test cases here
  }
  
  // make sure you have test cases for all the functions here
}
