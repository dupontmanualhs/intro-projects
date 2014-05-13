import org.scalatest.{ FunSuite, Matchers }
import scala.language.implicitConversions
import org.dupontmanual.image._

object SubsetsArrangements {
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
  
  /** given a List[X], produces ???
  def listFun[X](listOfX: List[X]): ??? = {
    listOfX match {
      case List() =>
      case head :: tail => head  listFun(tail)
    }
  } */
  
  /** STUFF FOR THIS ASSIGNMENT **/
  
  // you may want to use the ++ function for this assignment
  // List[X] ++ List[X] => List[X]
  // List(1, 2) ++ List(4, 5) => List(1, 2, 4, 5)
  
  /** given a List[X], produces a list of all subsets */
  def subsets[X](listOfX: List[X]): List[List[X]] = {
    listOfX match {
      case List() => ???
      case head :: tail => head  subsets(tail)
    }
  }
  
  /** given an X and a List[List[X]], 
      produces a new list with x added to the beginning of each list */
  def consOnAll[X](x: X, lists: List[List[X]]): List[List[X]] = {
    lists match {
      case List() => ???
      case head :: tail => head  consOnAll(tail)
    }
  }
  
  /** given a List[X], produces a list of all permutations of the list */
  def arrangements[X](listOfX: List[X]): List[List[X]] = {
    listOfX match {
      case List() => 
      case head :: tail => 
    }
  }
  
}

class TestSubsetsArrangements extends FunSuite with Matchers {
  import SubsetsArrangements._

  test("subsets") {
    subsets(List()) shouldEqual List(List())
    subsets(List("x")) shouldEqual List(List(), List("x"))
    subsets(List(3, 5)) shouldEqual List(List(), List(5), List(3), List(3, 5))
    subsets(List(1, 2, 3)) shouldEqual
        List() // you fill this one in
  }
  
  test("consOnAll") {
    consOnAll("a", List(List())) shouldEqual List(List("a"))
    consOnAll(0, List(List(), List(2, 4))) shouldEqual
        List(List(0), List(0, 2, 4))
    consOnAll("a", List(List("x", "y"), List("b", "c"))) shouldEqual
        List() // you fill this one in
  }
  
  test("arrangements") {
    arrangements(List()) shouldEqual List(List())
    arrangements(List("a")) shouldEqual List(List("a"))
    arrangements(List("a", "t")) shouldEqual List(List("a", "t"), List("t", "a"))
    arrangements(List("a", "c", "t")) shouldEqual
        List(List("a", "c", "t"), List("c", "a", "t"), List("c", "t", "a"),
             List("a", "t", "c"), List("t", "a", "c"), List("t", "c", "a"))
  }
  
}
