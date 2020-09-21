package future

import java.io.File

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Failure
import scala.util.Success

object information {

  def getListOfFiles(dir: String): Future[List[File]] = Future {
    val d = new File(dir)
    if (d.exists) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

  def main(args: Array[String]) {
    val files = getListOfFiles("/home/knoldus/IdeaProjects")
    Thread.sleep(5000)
    println(files)

  }
}