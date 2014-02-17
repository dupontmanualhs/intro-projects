import org.scalatest.{ FunSuite, Matchers }

object MixedData {
  sealed abstract class Document
  case class Letter(to: String, date: String, signature: String) extends Document
  case class Memo(to: String, from: String, date: String, subject: String) extends Document
  case class Resume(name: String, date: String, wasSent: Boolean) extends Document
  
  val l1: Letter = Letter("Justin Bieber", "2/11/2014", "Mom")
  val m1: Memo = Memo("Canada", "America", "2/11/2014", "Take Bieber Back")
  val r1: Resume = Resume("Justin Bieber", "2/12/2014", true)
  
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
  
  sealed abstract class EuclideanSolid
  case class Cube(side: Double) extends EuclideanSolid
  case class Sphere(radius: Double) extends EuclideanSolid
  case class Box(length: Double, width: Double, height: Double) extends EuclideanSolid
  
  val c1: Cube = Cube(4)
  val s1: Sphere = Sphere(3)
  val b1: Box = Box(5, 6, 7)
  
  /** given a EuclideanSolid, produces ???
  def euclideanSolidFun(euclideanSolid: EuclideanSolid): ??? = {
    euclideanSolid match {
      case Cube(side) => ???
      case Sphere(radius) => ???
      case Box(length, width, height) => ???
    }
  } */
  
  /** given a EuclideanSolid, produces its volume */
  def volume(euclideanSolid: EuclideanSolid): Double = {
    euclideanSolid match {
      case Cube(side) => math.pow(side, 3)
      case Sphere(radius) => (4.0 / 3) * math.Pi * math.pow(radius, 3)
      case Box(length, width, height) => length * width * height
    }
  }
  
  /** given a EuclideanSolid, produces its surface area */
  def surfaceArea(euclideanSolid: EuclideanSolid): Double = {
    euclideanSolid match {
      case Cube(side) => 6 * math.pow(side, 2)
      case Sphere(radius) => 4 * math.Pi * math.pow(radius, 2)
      case Box(length, width, height) => 2 * (length * width + length * height + width * height)
    }
  } 
  
  
  sealed abstract class Employee
  case class Principal(salary: Int, office: Int, degree: String) extends Employee
  case class Teacher(salary: Int, room: Int, degree: String) extends Employee
  case class Assistant(wage: Double, hoursWorked: Double) extends Employee
}

class TestMixedData extends FunSuite with Matchers {
  import MixedData._

  test("from") {
    from(l1) shouldEqual "Mom"
    from(m1) shouldEqual "America"
    from(r1) shouldEqual "Justin Bieber"
  }
  
  test("volume") {
    volume(c1) shouldEqual 64.0
    volume(s1) shouldEqual 36.0 * math.Pi +- 0.0000001
    volume(b1) shouldEqual 210.0
  }
  
  test("surfaceArea") {
    
}

