import org.scalatest.{ FunSuite, Matchers }
import org.dupontmanual.image._
  
object BasicAnimations {
  case class BasicWorld(frame: Int) extends World[BasicWorld] {  
    override def afterTick(): BasicWorld = {
      BasicWorld(frame + 1)
    }
    
    override def asImage(): Image = {
      super.asImage().placeImage(Circle(Color.Blue, 10), 50, frame)
    }
  }
}

class TestMoreNaturalNumbers extends FunSuite with Matchers {
  import BasicAnimations._
  initialize()

  test("BasicWorld") {
    BasicWorld(50).asImage() shouldEqual Rectangle(Color.White, 100, 100).placeImage(
        Circle(Color.Blue, 10), 50, 50)
  }

}
