import org.scalatest.{ FunSuite, Matchers }

object IntroToLists {
  sealed abstract class ListOfInt
  case class HtInt(head: Int, tail: ListOfInt) extends ListOfInt
  case object MtInt extends ListOfInt
  
  /** given a ListOf[T], produces ???
  def listOfTFun(listOfT: ListOfT): ??? = {
    listOfInt match {
      case HtInt(head, tail) => head  listOfIntFun(tail)
      case MtInt => ???
    }
  } */
  
  
}

class TestIntroToLists extends FunSuite with Matchers {
  import IntroToLists._

}
