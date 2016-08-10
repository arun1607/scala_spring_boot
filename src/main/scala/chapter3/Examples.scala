package chapter3

import scala.io.Source

/**
  * Created by amits on 28/07/16.
  */
object Examples {
  def main(args: Array[String]): Unit = {
    val checkSum: Int = CheckSumAccumulator.calculate("hello")
    println(checkSum)

  }
}

class CheckSumAccumulator {
  private var sum = 0

  def add(b: Byte) = sum += b

  def checkSum() = ~(sum & 0xFF) + 1
}

object CheckSumAccumulator {
  private val cache = new scala.collection.mutable.HashMap[String, Int]()

  def calculate(s: String): Int = {
    if (cache.contains(s)) {
      cache(s)
    } else {
      val acc = new CheckSumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val checkSum: Int = acc.checkSum()
      cache += (s -> checkSum)
      checkSum
    }
  }
}

