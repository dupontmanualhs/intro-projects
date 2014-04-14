import org.scalatest.{ FunSuite, Matchers }
import org.dupontmanual.image._
  
object Snake {
  sealed abstract class ListOf[+X] {
    def head: X
    def tail: ListOf[X]
  }
  case object Empty extends ListOf[Nothing] {
    def head: Nothing = throw new Exception("can't get head of Empty")
    def tail: ListOf[Nothing] = throw new Exception("can't get tail of Empty")
  }
  case class Cons[X](head: X, tail: ListOf[X]) extends ListOf[X]
  
  /////////////////////////////////////////////////

  case class SnakeWorld(direction: String, segLocs: ListOf[Point], foodLoc: Point) 
      extends World[SnakeWorld] { 
    override val width = 500 // the width of the board in pixels
    override val height = 300 // the height of the board in pixels
    
    // the background image that you'll draw the snake and food on
    // make sure it's the same size as the width and height you chose
    val background: Image = Rectangle(Color.Gray, 500, 300)
    
    // the image representing a segment of the snake
    val segPict: Image = Square(Color.Blue, 10) 
    
    // the image representing the food
    val foodPict: Image = Circle(Color.Green, 5)
    
    override def asImage(): Image = {
      drawSnake(segLocs)
    }
    
    // draws the snake on the background
    def drawSnake(pts: ListOf[Point]): Image = {
      pts match {
        case Empty => background.placeImage(foodPict, foodLoc.x, foodLoc.y)
        case Cons(head, tail) => drawSnake(tail).placeImage(segPict, head.x, head.y)
      }
    }
    
    // changes the direction to the key that's pressed or leaves it if something
    // other than an arrow key is pressed
    override def afterKeyPressed(key: String): SnakeWorld = {
      if (contains(Cons("UP", Cons("DOWN", Cons("LEFT", Cons("RIGHT", Empty)))), key)) {
        this.copy(direction = key)
      } else {
        this
      }
    }
    
    // given a list and an item, produces whether the list contains the item
    def contains[X](xs: ListOf[X], x: X): Boolean = {
      xs match {
        case Empty => false
        case Cons(head, tail) => head == x || contains(tail, x)
      }
    }
    
    override def afterTick(): SnakeWorld = {
      this.copy(segLocs = newSegLocs(segLocs, direction))
    }
    
    // given a Point and a direction, produces a new Point moved 20 pixels in the
    //    direction
    def pointInDir(pt: Point, dir: String): Point = {
      val newX = pt.x + (dir match {
        case "LEFT" => -10
        case "RIGHT" => 10
        case _ => 0
      })
      val newY = pt.y + (dir match {
        case "UP" => -10
        case "DOWN" => 10
        case _ => 0
      })
      Point(newX, newY)
    }
    
    def newSegLocs(oldLocs: ListOf[Point], dir: String): ListOf[Point] = {
      Cons(pointInDir(oldLocs.head, dir), removeLast(oldLocs))
    }
    
    def removeLast[X](oldLocs: ListOf[X]): ListOf[X] = {
      oldLocs match {
        case Cons(head, Empty) => Empty
        case Cons(head, tail) => Cons(head, removeLast(tail))
      }
    }
  }
  
  val simpleWorld: SnakeWorld = SnakeWorld(
    "LEFT",
    Cons(Point(50, 50), Empty),
    Point(100, 100)
  )
}

class TestSnake extends FunSuite with Matchers {
  import Snake._
  initialize()

  

}
