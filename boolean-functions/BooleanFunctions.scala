import org.dupontmanual.image._
import org.scalatest.{ FunSuite, Matchers }

object BooleanFunctions {
  // Sample Functions
  
  /** produces whether the string is "basketball" */
  def isBasketball(str: String): Boolean = {
    str == "basketball"
  }
  
  /** produces whether the given age is old enough to drive */
  def mayDrive(age: Int): Boolean = {
    age >= 16
  }
  
  /** produces whether the given age is between 18 and 25 (inclusive) */
  def is18to25(age: Int): Boolean = {
    18 <= age && age <= 25
  }
  
  // Your Functions

}

class TestBooleanFunctions extends FunSuite with Matchers {
  import BooleanFunctions._
 
  // Sample Functions
  
  test("isBasketball") {
    isBasketball("basketball") shouldEqual true
    isBasketball("baseball") shouldEqual false
    isBasketball("soccer") shouldEqual false
  }
  
  test("mayDrive") {
    mayDrive(10) shouldEqual false
    mayDrive(15) shouldEqual false
    mayDrive(16) shouldEqual true
    mayDrive(17) shouldEqual true
    mayDrive(45) shouldEqual true
  }
  
  test("is18to25") {
    is18to25(15) shouldEqual false
    is18to25(17) shouldEqual false
    is18to25(18) shouldEqual true
    is18to25(22) shouldEqual true
    is18to25(25) shouldEqual true
    is18to25(26) shouldEqual false
    is18to25(30) shouldEqual false
  }
  
  // Your Functions
  
}