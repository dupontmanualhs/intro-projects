import org.dupontmanual.image._
import org.scalatest.{ FunSuite, Matchers }

object ImageExercises {
  val Abacus: Image = Bitmap("images/abacus.png")
  val Balloons: Image = Bitmap("images/balloons.png")
  val Cake: Image = Bitmap("images/cake.png")
  val Dagger: Image = Bitmap("images/dagger.png")
  
  val img1: Image = Cake // replace this with code that makes 1.png
    
  val img2: Image = Cake // replace this with code that makes 2.png
  
  val img3: Image = Cake // ...
  
  // Continue on up to img25
}

class TestImageExercises extends FunSuite with Matchers {
  import ImageExercises._
  
  test("img1") {
    img1 shouldEqual Bitmap("images/1.png")
  }
  
  test("img2") {
    img2 shouldEqual Bitmap("images/2.png")
  }
  
  test("img3") {
    img3 shouldEqual Bitmap("images/3.png")
  }
  
  // Continue tests on up to img25
}