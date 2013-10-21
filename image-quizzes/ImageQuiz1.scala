import scala.util.Random

import org.dupontmanual.image._

object ImageQuiz1 {
  val R2D2 = Bitmap("images/R2D2.png")
  val Yoda = Bitmap("images/Yoda.png")
  
  val img = R2D2
  
  val pics = List(
    img.above(img).above(img).rotate(45.degrees),
    img.beside(img).beside(img),
    img.above(img).beside(img),
    img.flipHorizontal().beside(img.flipHorizontal()).beside(img.flipHorizontal()),
    img.rotate(45.degrees).above(img.rotate(45.degrees)).above(img.rotate(45.degrees)),
    img.rotate(180.degrees).beside(img.rotate(180.degrees)).beside(img.rotate(180.degrees)),
    img.above(img.beside(img)).rotate(90.degrees),
    img.beside(img).beside(img).rotate(90.degrees),
    img.rotate(90.degrees).above(img.rotate(90.degrees).beside(img.rotate(90.degrees)), XAlign.Right),
    img.rotate(90.degrees).beside(img.rotate(90.degrees)).beside(img.rotate(90.degrees)),
    img.rotate(45.degrees).cropBottom(34).above(
      img.rotate(45.degrees).cropBottom(34)).above(
        img.rotate(45.degrees).cropBottom(34)),
    img.flipVertical().beside(img.flipVertical()).beside(img.flipVertical()),
    img.cropLeft(24).rotate(45.degrees).above(
      img.cropLeft(24).rotate(45.degrees)).above(
        img.cropLeft(24).rotate(45.degrees)),
    img.beside(img).above(img),
    img.above(img).above(img)
  )
  
  val exprs = List(
    """img.above(img).above(img).rotate(45.degrees)""",
    """img.above(img).beside(img)""",
    """img.beside(img).beside(img)""",
    """img.flipHorizontal().beside(
      |  img.flipHorizontal()).beside(
      |    img.flipHorizontal())""".stripMargin,
    """img.rotate(45.degrees).above(
      |  img.rotate(45.degrees)).above(
      |    img.rotate(45.degrees))""".stripMargin,
    """img.rotate(180.degrees).beside(
      |  img.rotate(180.degrees)).beside(
      |    img.rotate(180.degrees))""".stripMargin,
    """img.above(img.beside(img)).rotate(90.degrees)""",
    """img.beside(img).beside(img).rotate(90.degrees)""",
    """img.rotate(90.degrees).above(
      |  img.rotate(90.degrees).beside(
      |    img.rotate(90.degrees)), XAlign.Right)""".stripMargin,
    """img.rotate(90.degrees).beside(
      |  img.rotate(90.degrees)).beside(
      |    img.rotate(90.degrees))""".stripMargin,
    """img.rotate(45.degrees).cropBottom(34).above(
      |  img.rotate(45.degrees).cropBottom(34)).above(
      |    img.rotate(45.degrees).cropBottom(34))""".stripMargin,
    """img.flipVertical().beside(
      |  img.flipVertical()).beside(
      |    img.flipVertical())""".stripMargin,
    """img.cropLeft(24).rotate(45.degrees).above(
      |  img.cropLeft(24).rotate(45.degrees)).above(
      |    img.cropLeft(24).rotate(45.degrees))""".stripMargin,
    """img.beside(img).above(img)""",
    """img.above(img).above(img)"""
  )
  
  val alphabet = "ABCDEFGHJKLMNOPQRSTUWXYZ"
    
  def savePics() {
    val rand = new Random()
    val shuffledPics = rand.shuffle(pics)
    shuffledPics.zip(alphabet) foreach {
      case (img: Image, ltr: Char) => img.saveAsDisplayed(s"images/${ltr}.png")
    }
  }
  
  def printExprs(name: String) {
    val rand = new Random()
    val shuffledExprs = rand.shuffle(exprs)
    val lines = shuffledExprs.zip(1 to shuffledExprs.length).map { 
      case (expr: String, num: Int) =>
        val prefix = s"_____ ${if (num < 10) s" $num" else s"$num"}. "
        val exprStr = expr.replaceAll("img", name).replaceAll("\n", s"\n${" " * prefix.length}")
        prefix + exprStr  
    }.mkString("\n")
    print(lines)
  }

}