import org.scalatest.{ FunSuite, Matchers }
import org.dupontmanual.image._

// For this assignment, do what the comments tell you. Search for #1, then
//  #2, #3, etc., and do what they say. It will help if you do them in order.

object IntroToLists {
  sealed abstract class ListOfStr {
    def head: String
    def tail: ListOfStr
  }
  case object EmptyStr extends ListOfStr {
    def head: String = throw new Exception("can't take head of EmptyStr")
    def tail: ListOfStr = throw new Exception("can't take tail of EmptyStr")
  }
  case class ConsStr(head: String, tail: ListOfStr) extends ListOfStr
  
  val s1: ListOfStr = EmptyStr
  val s2: ListOfStr = ConsStr("milk", ConsStr("bread", ConsStr("butter",
                          ConsStr("eggs", EmptyStr))))
  val subjects: ListOfStr = 
      ConsStr("Math", ConsStr("Science", 
          ConsStr("English", ConsStr("Social Studies", EmptyStr))))
  val taxonomy: ListOfStr =
      ConsStr("kingdom", ConsStr("phylum", ConsStr("class", ConsStr("order",
          ConsStr("family", ConsStr("genus", ConsStr("species", EmptyStr)))))))
          
  /** given a ListOfStr, produces ???
  def listOfStrFun(listOfStr: ListOfStr): ??? = {
    listOfStr match {
      case EmptyStr => ???
      case ConsStr(head, tail) => ???
    }
  } */
  
  sealed abstract class ListOfInt {
    def head: Int
    def tail: ListOfInt
  }
  case object EmptyInt extends ListOfInt {
    def head: Int = throw new Exception("can't take head of EmptyInt")
    def tail: ListOfInt = throw new Exception("can't take tail of EmptyInt")
  }
  case class ConsInt(head: Int, tail: ListOfInt) extends ListOfInt
  
  val fibonacci: ListOfInt = 
      ConsInt(0, ConsInt(1, ConsInt(2, ConsInt(3,
          ConsInt(5, ConsInt(8, ConsInt(13, EmptyInt)))))))
  
  /** given a ListOfInt, produces ???
  def listOfIntFun(listOfInt: ListOfInt): ??? = {
    listOfInt match {
      case EmptyInt => ???
      case ConsInt(head, tail) => ???
    }
  } */

  /** given a ListOfInt, produces its sum */
  def sum(listOfInt: ListOfInt): Int = {
    listOfInt match {
      case EmptyInt => 0
      case ConsInt(head, tail) => head + sum(tail)
    }
  }
  
  // #4. Write class definitions and a function template to handle 
  //     ListOfBool (for Booleans). The easiest way to do this is to
  //     copy/paste the code for ListOfStr or ListOfInt and make changes.
  //     Uncomment the ListOfBool test cases below to see if you did it
  //     right.
  
  
  // #5. Write class definitions and a function template to handle
  //     ListOfPt (for Points). Try to do this without copying or looking at
  //     the code for the other lists you've already written, since I'm
  //     going to make you do that on a quiz. (Don't worry if you don't get
  //     the wording of the Exception exactly right--it's enough that you
  //     remember that it throws an Exception.)
}

class TestIntroToLists extends FunSuite with Matchers {
  import IntroToLists._

  test("sum") {
    sum(EmptyInt) shouldEqual 0 
    // #1 change the 0 in the next two lines so the tests pass
    sum(ConsInt(3, ConsInt(2, ConsInt(4, EmptyInt)))) shouldEqual 0
    sum(fibonacci) shouldEqual 0
  }
  
  test("heads or tails") {
    // #2 change the "" in these test cases to the value that will make
    //   the tests pass
    subjects.head shouldEqual ""
    subjects.tail.tail.head shouldEqual ""
    taxonomy.tail.tail.tail.tail.tail.head shouldEqual ""
    taxonomy.tail.tail.tail.tail shouldEqual ""
    fibonacci.tail.tail.tail.head shouldEqual ""
    fibonacci.tail.tail.tail.tail shouldEqual ""
  }
  
  test("getting what you want") {
    // #3 change the "" in these test cases so that the tests pass.
    //  The catch is that you can only use subjects, taxonomy, fibonacci,
    //  .head, and .tail.
    "" shouldEqual "Social Studies"
    "" shouldEqual "family"
    "" shouldEqual ConsStr("genus", ConsStr("species", EmptyStr))
    "" shouldEqual ConsInt(5, ConsInt(8, ConsInt(13, EmptyInt)))
    // for the next one, you can use ConsInt and EmptyInt, too
    "" shouldEqual ConsInt(0, ConsInt(1, EmptyInt))
  }
  
  /* uncomment for #4
  test("ListOfBool") {
    val b1 = EmptyBool
    val b2 = ConsBool(true, ConsBool(true, ConsBool(true, EmptyBool)))
    val b3 = ConsBool(false, ConsBool(false, EmptyBool))
    val b4 = ConsBool(true, ConsBool(false, ConsBool(true, ConsBool(false, EmptyBool))))
    b2.head shouldEqual true
    b2.tail.head shouldEqual true
    b3.head shouldEqual false
    b3.tail.tail shouldEqual EmptyBool
    the [Exception] thrownBy b1.head should have message "can't take head of EmptyBool"
    the [Exception] thrownBy b2.tail.tail.tail.tail should have message "can't take tail of EmptyBool"
  }
  */
  
  /* uncomment for #5
  test("ListOfPt") {
    val p1 = EmptyPt
    val p2 = ConsPt(Point(10, 20), ConsPt(Point(50, 50), ConsPt(Point(75, 90), EmptyPt)))
    p2.head shouldEqual Point(10, 20)
    p2.tail shouldEqual ConsPt(Point(50, 50), ConsPt(Point(75, 90), EmptyPt))
    p2.tail.head shouldEqual Point(50, 50)
    p2.tail.tail.head shouldEqual Point(75, 90)
    the [Exception] thrownBy p1.head should have message "can't take head of EmptyPt"
    the [Exception] thrownBy p1.tail should have message "can't take tail of EmptyPt"
  }
  */
}
