package chapter7

import java.io.{FileNotFoundException, FileReader, IOException}


/**
  * Created by amits on 28/07/16.
  */
object ExceptionHandling extends App {
  try {
    val file = new FileReader("abc.txt")
  } catch {
    case ex: FileNotFoundException => Console.err.println("File not found")
    case ex: IOException => Console.err.println("Error occurred in file reading")
  }
}
