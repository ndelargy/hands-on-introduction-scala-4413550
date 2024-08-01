import java.io.{File, FileWriter}
import scala.io.Source
import scala.util.Using

@main def run: Unit =
  val input: String = ???
  val output: String = ???
  etl(input, output)

def etl(inputFilePath: String, outputFilePath: String): Unit =
  val extracted = extract(inputFilePath)
  val transformed = transform(extracted)
  load(transformed, outputFilePath)

def extract(input: String): List[String] = Using.resource(Source.fromFile(input))(_.getLines.toList)
def transform(input: List[String]): List[String] = input.map(line => line.toLowerCase)
def load(data: List[String], output: String = "src/main/resources/output.txt"): Unit =
  val file = new File(output)
  val fileWriter = new FileWriter(file)
  fileWriter.write(data.mkString("\n"))
  fileWriter.close()
