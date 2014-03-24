import org.scalatest.{ FunSuite, Matchers }
import org.dupontmanual.image._

object NaturalNumbers {
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
  
  type Nat = BigInt
  val Zero: Nat = BigInt(0)
  
  /** given a Nat, produces ???
  def nFun(n: Nat): ??? = {
    n match {
      case Zero => ???
      case n if n > 0 => n  nFun(n - 1)
      case _ => throw new Exception("Nat must be non-negative")
    }
  } */
  
  /** given a Nat, produces ??? */
  def factorial(n: Nat): Nat = {
    n match {
      case Zero => 1
      case n if n > 0 => n * factorial(n - 1)
      case _ => throw new Exception("Nat must be non-negative")
    }
  }
  
  /** given a Nat n, produces a list with n "hello"s in it */ 
  def hellos(n: Nat): ListOf[String] = {
    n match {
      case Zero => Empty
      case n if n > 0 => Cons("hello", hellos(n - 1))
      case _ => throw new Exception("Nat must be non-negative")
    }
  } 
  
  /** given a Nat, a radius, and a Color, produces a picture of that many circles */
  def circles(n: Nat, radius: Int, color: Color): Image = {
    n match {
      case Zero => RectangleFilled(Color.White, 0, 0)
      case n if n > 0 => CircleFilled(color, radius).beside(circles(n - 1, radius, color))
      case _ => throw new Exception("Nat must be non-negative")
    }
  }
  
  
}

class TestNaturalNumbers extends FunSuite with Matchers {
  import NaturalNumbers._

  test("factorial") {
    factorial(0) shouldEqual 1
    factorial(1) shouldEqual 1
    factorial(4) shouldEqual 24
    factorial(10) shouldEqual 3628800
    factorial(20) shouldEqual BigInt("2432902008176640000")
  }
  
  test("hellos") {
    hellos(0) shouldEqual Empty
    hellos(1) shouldEqual Cons("hello", Empty)
    hellos(5) shouldEqual 
        Cons("hello", Cons("hello", Cons("hello", Cons("hello", Cons("hello", Empty)))))
  }
}
