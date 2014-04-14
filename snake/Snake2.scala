/*import org.scalatest.{ FunSuite, Matchers }
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
    override val width = ??? // the width of the board in pixels
    override val height = ??? // the height of the board in pixels
    
    // the background image that you'll draw the snake and food on
    // make sure it's the same size as the width and height you chose
    val background: Image = ???
    
    // the image representing a segment of the snake
    val segPict: Image = ???
    
    // the image representing the food
    val foodPict: Image = ???
    
    override def asImage(): Image = {
      drawSnake(segLocs)
    }
    
    // draws the snake on the background
    def drawSnake(pts: ListOf[Point]): Image = {
      pts match {
        case Empty => ??? // should be a picture of the background with 
                          // the food drawn in the right place
        case Cons(head, tail) => head   drawSnake(tail) // you'll need to change
                         // this so it places a segPict where the head belongs
                         // in the image represented by drawSnake(tail)
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
*/
