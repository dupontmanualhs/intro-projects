import org.dupontmanual.image._
import org.scalatest.{ FunSuite, Matchers }

object FunctionComposition {
  /** produces total profit given ticket price */
  def profitBad(price: Double): Double = {
    (price * (120 - 15 * ((price - 5.00) / 0.10))) -
    (180 + 0.04 * (120 - 15 * ((price - 5.00) / 0.10)))
  }
  
  /** produces total profit given ticket price */
  def profitGood(price: Double): Double = {
    income(price) - cost(price)
  }
  
  /** produces total income given ticket price */
  def income(price: Double): Double = {
    price * customers(price)
  }
  
  /** produces total cost to theater owner given ticket price */
  def cost(price: Double): Double = {
    180 + 0.04 * customers(price)
  }
  
  /** produces the number of customers given a ticket price */
  def customers(price: Double): Double = {
    120 - 15 * ((price - 5.00) / 0.10)
  }
}

class TestFunctionComposition extends FunSuite with Matchers {
  test("profitBad") {
    
  }
  
  test("profitGood") {
    
  }
}