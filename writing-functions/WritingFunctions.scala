import org.dupontmanual.image._
import org.scalatest.{ FunSuite, Matchers }

object WritingFunctions {
  // given three colors and a size in pixels,
  // produces an Image of three squares next to each other
  def threeSquares(left: Color, center: Color, right: Color, size: Int): Image = {
    SquareFilled(left, size).beside(
    SquareFilled(center, size)).beside(
    SquareFilled(right, size))
  }
  
}

class TestWritingFunctions extends FunSuite with Matchers {
  import WritingFunctions._

  test("threeSquares") {
    threeSquares(Color.Red, Color.Blue, Color.Green, 20) shouldEqual Bitmap("images/threeSquares1.png")
    threeSquares(Color.Orange, Color.Black, Color.Brown, 30) shouldEqual Bitmap("images/threeSquares2.png")
    threeSquares(Color.Pink, Color.Red, Color.Black, 40) shouldEqual Bitmap("images/threeSquares3.png")
  }
  
  /*
  test("pinwheel") {
    pinwheel(Hacker) shouldEqual Bitmap("images/pinwheel1.png")
    pinwheel(Calendar) shouldEqual Bitmap("images/pinwheel2.png")
    pinwheel(Book) shouldEqual Bitmap("images/pinwheel3.png")    
  }
  */
  
  /*
  test("bullseye") {
    bullseye(20, 10, Color.Green, Color.Pink) shouldEqual Bitmap("images/bullseye1.png")
    bullseye(50, 5, Color.Black, Color.Blue) shouldEqual Bitmap("images/bullseye2.png")
    bullseye(30, 25, Color.Maroon, Color.Fuchsia) shouldEqual Bitmap("images/bullseye3.png")
  }
  */
  
  /*
  test("lollipop") {
    lollipop(10, 30, Color.Purple) shouldEqual Bitmap("images/lollipop1.png")
    lollipop(20, 5, Color.Red) shouldEqual Bitmap("images/lollipop2.png")
    lollipop(15, 50, Color.Green) shouldEqual Bitmap("images/lollipop3.png")
  }
  */
  
  /*
  test("boxes") {
    boxes(10, Color.Blue, 20, Color.Green) shouldEqual Bitmap("images/boxes1.png")
    boxes(50, Color.Red, 20, Color.Goldenrod) shouldEqual Bitmap("images/boxes2.png")
    boxes(20, Color.Chartreuse, 20, Color.Teal) shouldEqual Bitmap("images/boxes3.png")
  }
  */
  
  /*
  test("threeOvals") {
    threeOvals(Color.Aqua, Color.Tan, 20, 50) shouldEqual Bitmap("images/threeOvals1.png")
    threeOvals(Color.Cyan, Color.Orange, 50, 20) shouldEqual Bitmap("images/threeOvals2.png")
    threeOvals(Color.Magenta, Color.Gray, 30, 75) shouldEqual Bitmap("images/threeOvals3.png")
  }
  */
}