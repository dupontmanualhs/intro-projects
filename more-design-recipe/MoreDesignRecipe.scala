import scala.math.Pi

import org.scalatest.{ FunSuite, Matchers }

import org.dupontmanual.image._

object MoreDesignRecipe {
  // write the functions here -- make sure you use the correct names!
}

class TestMoreDesignRecipe extends FunSuite with Matchers {
  import MoreDesignRecipe._
  
  // make sure you write all the test cases that are
  // listed in the assignment
  
  test("volumeOfRectPrism") {
    volumeOfRectPrism(2, 3, 7) shouldEqual 42
  }
  
}