import org.scalatest.{ FunSuite, Matchers }

object MixedData {
  sealed abstract class Document
  case class Letter(to: String, date: String, signature: String) extends Document
  case class Memo(to: String, from: String, date: String, subject: String) extends Document
  case class Resume(name: String, date: String, wasSent: Boolean) extends Document
  
  val l1: Letter = Letter("CIA", "2/11/2014", "Todd O'Bryan")
  val m1: Memo = Memo("Jennifer Ding", "Todd O'Bryan", "2/11/2014", "Talk Less")
  val r1: Resume = Resume("Todd O'Bryan", "11/11/2013", true)
  
  /** given a Document, produces ???
  def documentFun(document: Document): ??? = {
    document match {
      case Letter(to, date, signature) => ???
      case Memo(to, from, date, subject) => ???
      case Resume(name, date, wasSent) => ???
    }
  } */
  
  /** given a Document, produces the name of its author */
  def from(document: Document): String = {
    document match {
      case Letter(to, date, signature) => signature
      case Memo(to, from, date, subject) => from
      case Resume(name, date, wasSent) => name
    }
  }
  
}

class TestMixedData extends FunSuite with Matchers {
  import MixedData._

  test("from") {
    from(l1) shouldEqual "Todd O'Bryan"
    from(m1) shouldEqual "Todd O'Bryan"
    from(r1) shouldEqual "Todd O'Bryan"
  }
}

