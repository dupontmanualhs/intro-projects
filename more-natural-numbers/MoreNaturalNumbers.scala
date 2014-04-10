import org.scalatest.{ FunSuite, Matchers }
import org.dupontmanual.image._

object MoreNaturalNumbers {
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
      case n if n > 0 => n  nFun(sub1(n))
      case _ => throw new Exception("Nat must be non-negative")
    }
  } */
  
  def add1(n: Nat): Nat = {
    n + 1
  }
  
  def add1(x: Double): Double = {
    x + 1
  }
  
  def sub1(n: Nat): Nat = {
    n - 1
  }
  
  def sub1(x: Double): Double = {
    x - 1
  }
  
  sealed abstract class AltNat {
    def pred: AltNat
  }
  case object AltZero extends AltNat {
    def pred: AltNat = throw new Exception("can't take pred of AltZero")
  }
  case class Succ(pred: AltNat) extends AltNat
  
  /** given an AltNat, produces ...
  def altNatFun(an: AltNat): ??? = {
    an match {
      case AltZero => ???
      case Succ(pred) => altNatFun(pred)
    }
  } */
  
}

class TestMoreNaturalNumbers extends FunSuite with Matchers {
  import MoreNaturalNumbers._

  /* make sure you add your own test cases, too */
  /*
  test("addAltNats") {
    addAltNats(AltZero, AltZero) shouldEqual AltZero
    addAltNats(Succ(AltZero), Succ(Succ(AltZero))) shouldEqual Succ(Succ(Succ(AltZero)))
  }
  
  test("multiplyAltNats") {
    multiplyAltNats(AltZero, Succ(Succ(Succ(AltZero)))) shouldEqual AltZero
    multiplyAltNats(Succ(Succ(Succ(AltZero))), AltZero) shouldEqual AltZero
    multiplyAltNats(Succ(Succ(AltZero)), Succ(Succ(Succ(AltZero)))) shouldEqual
      Succ(Succ(Succ(Succ(Succ(Succ(AltZero))))))
  }
  
  test("altNatToNat") {
    altNatToNat(AltZero) shouldEqual 0
    altNatToNat(Succ(Succ(Succ(Succ(AltZero))))) shouldEqual 4
  }
  
  test("natToAltNat") {
    natToAltNat(0) shouldEqual AltZero
    natToAltNat(5) shouldEqual Succ(Succ(Succ(Succ(Succ(AltZero)))))
  }
  */
}
