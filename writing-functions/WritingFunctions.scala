import org.dupontmanual.image._
import org.scalatest.{ FunSuite, Matchers }

object WritingFunctions {
  /** produces: an image of three squares next to each other */
  def threeSquares(left: Color, center: Color, right: Color, size: Int): Image = {
    SquareFilled(left, size).beside(
      SquareFilled(center, size)).beside(
        SquareFilled(right, size))
  }
}

class TestWritingFunctions extends FunSuite with Matchers {
  import WritingFunctions._

  test("threeSquares examples") {
    val ts1: Image = ??? // define an image that looks like threeSquares1.png here
    val ts2: Image = ??? // define an image that looks like threeSquares2.png here
    val ts3: Image = ??? // define an image that looks like threeSquares3.png here
    ts1 shouldEqual Bitmap("images/threeSquares1.png")
    ts2 shouldEqual Bitmap("images/threeSquares2.png")
    ts3 shouldEqual Bitmap("images/threeSquares3.png")    
  }
  
  test("threeSquares") {    
    threeSquares(Color.Red, Color.Blue, Color.Green, 20) shouldEqual Bitmap("images/threeSquares1.png")
    threeSquares(Color.Orange, Color.Black, Color.Brown, 30) shouldEqual Bitmap("images/threeSquares2.png")
    threeSquares(Color.Pink, Color.Red, Color.Black, 40) shouldEqual Bitmap("images/threeSquares3.png")
  }
  
  test("pinwheel examples") {
    val pw1: Image = ???
    val pw2: Image = ???
    val pw3: Image = ???
    pw1 shouldEqual Bitmap("images/pinwheel1.png")
    pw2 shouldEqual Bitmap("images/pinwheel2.png")
    pw3 shouldEqual Bitmap("images/pinwheel3.png")
  }
  
  /*
  test("pinwheel") {
    pinwheel(Hacker) shouldEqual Bitmap("images/pinwheel1.png")
    pinwheel(Calendar) shouldEqual Bitmap("images/pinwheel2.png")
    pinwheel(Book) shouldEqual Bitmap("images/pinwheel3.png")    
  }
  */
  
  test("bullseye examples") {
    val be1: Image = ???
    val be2: Image = ???
    val be3: Image = ???
    be1 shouldEqual Bitmap("images/bullseye1.png")
    be2 shouldEqual Bitmap("images/bullseye2.png")
    be3 shouldEqual Bitmap("images/bullseye3.png")
  }
  
  /*
  test("bullseye") {
    bullseye(20, 10, Color.Green, Color.Pink) shouldEqual Bitmap("images/bullseye1.png")
    bullseye(50, 5, Color.Black, Color.Blue) shouldEqual Bitmap("images/bullseye2.png")
    bullseye(30, 25, Color.Maroon, Color.Fuchsia) shouldEqual Bitmap("images/bullseye3.png")
  }
  */
  
  test("lollipop examples") {
    val lp1: Image = ???
    val lp2: Image = ???
    val lp3: Image = ???
    lp1 shouldEqual Bitmap("images/lollipop1.png")
    lp2 shouldEqual Bitmap("images/lollipop2.png")
    lp3 shouldEqual Bitmap("images/lollipop3.png")
  }

  /*
  test("lollipop") {
    lollipop(10, 30, Color.Purple) shouldEqual Bitmap("images/lollipop1.png")
    lollipop(20, 5, Color.Red) shouldEqual Bitmap("images/lollipop2.png")
    lollipop(15, 50, Color.Green) shouldEqual Bitmap("images/lollipop3.png")
  }
  */
  
  test("boxes examples") {
    val bx1: Image = ???
    val bx2: Image = ???
    val bx3: Image = ???
    bx1 shouldEqual Bitmap("images/boxes1.png")
    bx2 shouldEqual Bitmap("images/boxes2.png")
    bx3 shouldEqual Bitmap("images/boxes3.png")
  }

  /*
  test("boxes") {
    boxes(10, Color.Blue, 20, Color.Green) shouldEqual Bitmap("images/boxes1.png")
    boxes(50, Color.Red, 20, Color.Goldenrod) shouldEqual Bitmap("images/boxes2.png")
    boxes(20, Color.Chartreuse, 20, Color.Teal) shouldEqual Bitmap("images/boxes3.png")
  }
  */
  
  test("threeOvals examples") {
    val to1: Image = ???
    val to2: Image = ???
    val to3: Image = ???
    to1 shouldEqual Bitmap("images/bullseye1.png")
    to2 shouldEqual Bitmap("images/bullseye2.png")
    to3 shouldEqual Bitmap("images/bullseye3.png")
  }

  /*
  test("threeOvals") {
    threeOvals(Color.Aqua, Color.Tan, 20, 50) shouldEqual Bitmap("images/threeOvals1.png")
    threeOvals(Color.Cyan, Color.Orange, 50, 20) shouldEqual Bitmap("images/threeOvals2.png")
    threeOvals(Color.Magenta, Color.Gray, 30, 75) shouldEqual Bitmap("images/threeOvals3.png")
  }
  */
}