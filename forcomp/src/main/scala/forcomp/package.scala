import java.io.File
import java.io.FileInputStream

package object forcomp {
  val dictionaryPath = List("forcomp", "linuxwords.txt")

  def loadDictionary = {
    val wordstream = Option {
      new FileInputStream("/Users/steinar/Documents/scalaprog/forcomp/src/main/resources/forcomp/linuxwords.txt")
      //getClass.getResourceAsStream(dictionaryPath.mkString("/"))
    } orElse {
      common.resourceAsStreamFromSrc(dictionaryPath)
    } getOrElse {
      sys.error("Could not load word list, dictionary file not found")
    }
    try {
      val s = io.Source.fromInputStream(wordstream)
      s.getLines.toList
    } catch {
      case e: Exception =>
        println("Could not load word list: " + e)
        throw e
    } finally {
      wordstream.close()
    }
  }

}
