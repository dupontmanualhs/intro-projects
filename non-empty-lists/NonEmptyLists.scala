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
      case Empty => ???
      case Cons(head, tail) => head  listOfXFun(tail)
    }
  } */
  
  type NonEmptyListOf[X] = Cons[X]
  
  /** given a NonEmptyListOf[X], produces ...
  def neloxFun(nelox: NonEmptyListOf[X]): ??? = {
    nelox match {
      case Cons(head, Empty) => 
      case Cons(head, tail: NonEmptyListOf[X]) => head  neloxFun(tail)
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
  
  /** given a NonEmptyListOf[Double], produces the largest element in the list */
  def max(nums: NonEmptyListOf[Double]): Double = {
    nums match {
      case Cons(head, Empty) => head
      case Cons(head, tail: NonEmptyListOf[Double]) =>
        val maxOfTail: Double = max(tail)
        if (head > maxOfTail) head else maxOfTail
    }
  }
  
  /** given two Points, finds the distance between them */
  def distance(p1: Point, p2: Point): Double = {
    import math._
    sqrt(pow(p1.x - p2.x, 2) + pow(p1.y - p2.y, 2))
  }
 
  /** given a list of at least 2 Points, produces the total distance you'd travel
      to visit each in order */
  def totalDistance(pts: ListOf[Point]): Double = {
    pts match {
      case Cons(one, Cons(two, Empty)) => distance(one, two)
      case Cons(one, Cons(two, tail: NonEmptyListOf[Point])) => distance(one, two) + totalDistance(Cons(two, tail))
      case _ => throw new Exception("must have at least two values in the list")
    }
  }

  /** given a list of at least 2 Points, produces a picture connecting the points
      on a white rectangle of size 100 by 100 */
  def openPolygon(points: ListOf[Point]): Image = {
    points match {
      case Cons(one, Cons(two, Empty)) => 
        RectangleFilled(Color.White, 100, 100).addLine(one.x, one.y, two.x, two.y)
      case Cons(one, Cons(two, tail: NonEmptyListOf[Point])) => 
        openPolygon(Cons(two, tail)).addLine(one.x, one.y, two.x, two.y)
      case _ => throw new Exception("must have at least two values in the list")
    }
  }

  /** given an item and a list, produces a new list with the item at the end */
  def putAtEnd[X](x: X, listOfX: ListOf[X]): ListOf[X] = {
    listOfX match {
      case Empty => Cons(x, Empty)
      case Cons(head, tail) => Cons(head, putAtEnd(x, tail))
    }
  }
  
  /** given a ListOf[X], produces a new list with the items reversed */
  def reverse[X](listOfX: ListOf[X]): ListOf[X] = {
    listOfX match {
      case Empty => Empty
      case Cons(head, tail) => putAtEnd(head, reverse(tail))
    }
  }
  
  /** given a ListOf[Point], produces an image of a closed polygon 
      connecting the points */
  def closedPolygon(points: ListOf[Point]): Image = {
    openPolygon(putAtEnd(points.head, points))
  }
  
}

class TestNonEmptyLists extends FunSuite with Matchers {
  import NonEmptyLists._

  test("product") {
    product(Cons(1, Empty)) shouldEqual 1
    product(Cons(3, Cons(4, Cons(2, Empty)))) shouldEqual 24
  }
  
  // uncomment each test as you write the functions
  // make sure you write your own test cases!
  
  test("max") {
    max(Cons(3.5, Empty)) shouldEqual 3.5
    max(Cons(3.5, Cons(-2.7, Cons(5.1, Cons(3.4, Empty))))) shouldEqual 5.1
  }
  
  test("distance") {
    distance(Point(5, 5), Point(5, 5)) shouldEqual 0
    distance(Point(5, 5), Point(8, 9)) shouldEqual 5.0
    distance(Point(5, 5), Point(20, 30)) shouldEqual math.sqrt(850)
  }
  
  test("totalDistance") {
    the [Exception] thrownBy totalDistance(Empty) should have message "must have at least two values in the list"
    the [Exception] thrownBy totalDistance(Cons(Point(0, 0), Empty)) should have message "must have at least two values in the list"
    totalDistance(Cons(Point(5, 5), Cons(Point(8, 9), Empty))) shouldEqual 5.0
    totalDistance(Cons(Point(5, 5), Cons(Point(8, 9), 
        Cons(Point(3, -3), Cons(Point(0, 0), Empty))))) shouldEqual
        18 + math.sqrt(18)
  }
  
  test("openPolygon") {
    the [Exception] thrownBy openPolygon(Empty) should have message "must have at least two values in the list"
    the [Exception] thrownBy openPolygon(Cons(Point(0, 0), Empty)) should have message "must have at least two values in the list"
    openPolygon(Cons(Point(0, 0), Cons(Point(50, 50), Empty))) shouldEqual Bitmap("poly1.png")
    openPolygon(Cons(Point(10, 10), Cons(Point(20, 20), Cons(Point(10, 30), 
        Cons(Point(20, 50), Cons(Point(5, 35), Empty)))))) shouldEqual Bitmap("poly2.png")
  }
  
  test("putAtEnd") {
    putAtEnd("a", Cons("z", Cons("y", Cons("x", Empty)))) shouldEqual 
      Cons("z", Cons("y", Cons("x", Cons("a", Empty))))
    putAtEnd(2, Empty) shouldEqual Cons(2, Empty)
  }
  
  test("reverse") {
    reverse(Empty) shouldEqual Empty
    reverse(Cons("a", Cons("b", Cons("c", Empty)))) shouldEqual 
        Cons("c", Cons("b", Cons("a", Empty)))
  }
  
  test("closedPolygon") {
    closedPolygon(Cons(Point(0, 0), Cons(Point(50, 50), Empty))) shouldEqual Bitmap("poly3.png")
    closedPolygon(Cons(Point(10, 10), Cons(Point(20, 20), Cons(Point(10, 30), 
        Cons(Point(20, 50), Cons(Point(5, 35), Empty)))))) shouldEqual Bitmap("poly4.png")
  }
    

}
