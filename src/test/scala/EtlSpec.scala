import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

import scala.io.Source
import scala.util.{Success, Try, Using}

class EtlSpec extends AnyFreeSpec with Matchers {
  "etl" - {
    "transforms a text file by making all the text lowercase ans saving this to a new file" in {
      val input = "/Users/delarn01/training/hands-on-introduction-scala-4413550/src/test/scala/resources/input.txt"
      val output = "/Users/delarn01/training/hands-on-introduction-scala-4413550/src/test/scala/resources/output.txt"
      val expectedFileContents = List("hello world")
      etl(input, output)
      readFile(output) shouldEqual Success(expectedFileContents)
    }
  }
  private def readFile(filePath: String): Try[List[String]] =
    Using(Source.fromFile(filePath))(_.getLines.toList)
}
