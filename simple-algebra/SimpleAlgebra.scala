import org.scalatest.{ FunSuite, Matchers }
import math.{ pow, Pi }

object SimpleAlgebra {
  // f(x) = 3x^2 - 1
  def f(x: Double): Double = {
    3 * pow(x, 2) - 1
  }
  
  // g(x) = 2x - 4

  // d(x) = x^2

  // s(k) = k^2 - k + 3

  // h(z) = 2z^3 - z^2 + z - 4

  // p(n) = n(n + 1) / 2
  
  // v(r, h) = πr^2h  (that's pi r-squared h, not pi r to the quantity 2h)
  // you'll use Pi to represent the value π

}

class TestSimpleAlgebra extends FunSuite with Matchers {
  import SimpleAlgebra._
  
  test("f") {
    /*
    f(x) = 3x^2 - 1
    
     x | f(x)
    ---+-----
    -2 | 11
    -1 | 2
     0 | -1
     1 | 2
     2 | 11
    */
    f(-2) shouldEqual 11
    f(-1) shouldEqual 2
    f(0) shouldEqual -1
    f(1) shouldEqual 2
    f(2) shouldEqual 11
  }
  
  test("d") {
    /*
    d(x) = x^2
    
     x | d(x)
    ---+-----
    -2 | 
    -1 |
     0 |
     1 |
     2 |
     */
    
  }
  
  test("g") {
    /*
    g(x) = 2x - 4
    
     x | g(x)
    ---+-----
    -2 |
    -1 |
     0 |
     1 |
     2 |
    */
    
  }
  
  test("s") {
    /*
    s(k) = k^2 - k + 3
    
     k | s(k)
    ---+-----
    -2 | 
    -1 | 
     0 |
     1 |
     2 |
    */

  }

  test("h") {
    /*
    h(z) = 2z^3 - z^2 + z - 4
    
     z | h(z)
    ---+-----
    -2 | 
    -1 | 
     0 |
     1 |
     2 |
    */
    
  }
  
  test("p") {
    /*
    p(n) = n(n + 1) / 2
    
     n | p(n)
    ---+-----
     0 | 
     1 | 
     2 |
     5 |
    10 | 
     */
  }
  
  test("v") {
    /*
    v(r, h) = πr^2h
    (you can copy/paste the π character in the t-chart)
    
      r  |  h  | v(r, h)
    -----+-----+--------- 
      1  |  1  | π
      2  |  3  | 12π
      3  |  1  |
      3  |  2  |
      1  |  7  |
      2  |  5  |
      4  |  2  |
    */
  }
}