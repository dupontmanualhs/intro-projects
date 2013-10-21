import org.scalatest.{ FunSuite, Matchers }

import org.dupontmanual.image._

object DiamondEtc {
}

class TestDiamondEtc extends FunSuite with Matchers {
  import DiamondEtc._
  
  test("diamond examples") {
    val diamond1: Image = ???
    val diamond2: Image = ???
    diamond1 shouldEqual Bitmap("images/diamond1.png")
    diamond2 shouldEqual Bitmap("images/diamond2.png")
  }
  
  /*
  test("diamond") {
    diamond(Color.Blue, 30) shouldEqual Bitmap("images/diamond1.png")
    diamond(Color.Green, 50) shouldEqual Bitmap("images/diamond2.png")
  }
  */
  
  test("textBox examples") {
    val textBox1: Image = ???
    val textBox2: Image = ???
    textBox1 shouldEqual Bitmap("images/textBox1.png")
    textBox2 shouldEqual Bitmap("images/textBox2.png")
  }
  
  /*
  test("textBox") {
    textBox("Hello", Color.Red, 100, 50) shouldEqual Bitmap("images/textBox1.png")
    textBox("Epic Fail", Color.SkyBlue, 20, 30) shouldEqual Bitmap("images/textBox2.png")
  }
  */
  
  test("twoEyes examples") {
    val twoEyes1: Image = ???
    val twoEyes2: Image = ???
    twoEyes1 shouldEqual Bitmap("images/twoEyes1.png")
    twoEyes2 shouldEqual Bitmap("images/twoEyes2.png")
  }
  
  /*
  test("twoEyes") {
    twoEyes(100, Color.Blue) shouldEqual Bitmap("images/twoEyes1.png")
    twoEyes(50, Color.Yellow) shouldEqual Bitmap("images/twoEyes2.png")
  }
  */
  
  test("circleInSquare examples") {
    val circleInSquare1: Image = ???
    val circleInSquare2: Image = ???
    val circleInSquare3: Image = ???
    circleInSquare1 shouldEqual Bitmap("images/circleInSquare1.png")
    circleInSquare2 shouldEqual Bitmap("images/circleInSquare2.png")
    circleInSquare3 shouldEqual Bitmap("images/circleInSquare3.png")
  }
  
  /*
  test("circleInSquare") {
    circleInSquare(50, Color.Red, Color.Blue) shouldEqual Bitmap("images/circleInSquare1.png")
    circleInSquare(30, Color.Green, Color.Goldenrod) shouldEqual Bitmap("images/circleInSquare2.png")
    circleInSquare(100, Color.Chartreuse, Color.Lime) shouldEqual Bitmap("images/circleInSquare3.png")
  }
  */
}