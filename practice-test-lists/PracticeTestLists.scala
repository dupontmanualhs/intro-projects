import org.dupontmanual.image._
import org.scalatest.{ FunSuite, Matchers }

object PracticeTestLists {
  sealed abstract class ListOf[+X] {
    def head: X
    def tail: ListOf[X]
  }
  case object Empty extends ListOf[Nothing] {
    def head: Nothing = throw new Exception("can't take head of Empty")
    def tail: ListOf[Nothing] = throw new Exception("can't take tail of Empty")
  }
  case class Cons[X](head: X, tail: ListOf[X]) extends ListOf[X]
  
  /** given a ListOf[X], produces ???
  def listOfXFun(listOfX: ListOf[X]): ??? = {
    listOfX match {
      case Empty => ???
      case Cons(head, tail) => head   listOfXFun(tail)
    }
  } */
  
  type NonEmptyListOf[X] = Cons[X]
  
  /** given a ListOf[Int], produces its product */
  def product(nums: ListOf[Int]): Int = {
    nums match {
      case Empty => 1
      case Cons(head, tail) => head * product(tail)
    }
  }
  
  /** given a ListOf[Point], produces an image with a black circle of radius 5
      at each location on a 100x100 white rectangle */
  def drawCircles(points: ListOf[Point]): Image = {
    points match {
      case Empty => RectangleFilled(Color.White, 100, 100)
      case Cons(head, tail) => 
        drawCircles(tail).placeImage(CircleFilled(Color.Black, 5), head.x, head.y)
    }
  }
  
  /** given a ListOf[Double] and a factor, produces a new list with each number
      multiplied by the given factor */
  def multiplyBy(values: ListOf[Double], factor: Double): ListOf[Double] = {
    values match {
      case Empty => Empty
      case Cons(head, tail) => Cons(factor * head, multiplyBy(tail, factor))
    }
  }
  
  /** given a ListOf[X] and an item,
      produces a new list with the item at the end */ 
  def putAtEnd[X](item: X, listOfX: ListOf[X]): ListOf[X] = {
    listOfX match {
      case Empty => Cons(item, Empty)
      case Cons(head, tail: ListOf[X]) => Cons(head, putAtEnd(item, tail))
    }
  }

  /** given a ListOf[X], produces the number of elements in the list */
  def howMany[X](listOfX: ListOf[X]): Int = {
    listOfX match {
      case Empty => 0
      case Cons(head, tail) => 1 + howMany(tail)
    }
  }
  
  /** given a NonEmptyListOf[Double], produces the smallest one */
  def min(nums: NonEmptyListOf[Double]): Double = {
    nums match {
      case Cons(num, Empty) => num
      case Cons(head, tail: NonEmptyListOf[Double]) => 
        if (head <= min(tail)) head 
        else min(tail)
    }
  }
}

class TestPracticeTestLists extends FunSuite with Matchers {
  import PracticeTestLists._
  
  test("product") {
    product(Empty) shouldEqual 1
    product(Cons(3, Cons(1, Cons(4, Empty)))) shouldEqual 12
  }
  
  test("drawCircles") {
    drawCircles(Empty) shouldEqual RectangleFilled(Color.White, 100, 100)
    drawCircles(Cons(Point(50, 50), Cons(Point(75, 25), 
        Cons(Point(25, 25), Empty)))) shouldEqual Bitmap("image1.png")
  }
  
  test("multiplyBy") {
    multiplyBy(Empty, 3) shouldEqual(Empty)
    multiplyBy(Cons(2.5, Cons(3.1, Cons(1.0, Empty))), 2) shouldEqual
        Cons(5.0, Cons(6.2, Cons(2.0, Empty)))
  }
  
  test("putAtend") {
    putAtEnd(5, Empty) shouldEqual Cons(5, Empty)
    putAtEnd("a", Cons("x", Cons("y", Cons("z", Empty)))) shouldEqual
        Cons("x", Cons("y", Cons("z", Cons("a", Empty))))
  }
  
  test("howMany") {
    howMany(Empty) shouldEqual 0
    howMany(Cons(true, Cons(false, Cons(false, Cons(true, Empty))))) shouldEqual 4
  }
  
  test("min") {
    min(Cons(1.7, Empty)) shouldEqual 1.7
    min(
        Cons(5.7, Cons(2.4, Cons(3.7, Cons(4.9, Empty))))
    ) shouldEqual 2.4
  }
}

