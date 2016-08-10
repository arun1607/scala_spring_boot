package chapter3

import chapter3.CheckSumAccumulator.calculate

/**
  * Created by amits on 28/07/16.
  */
object Summer extends App {
  println(calculate("hello world"))

  val name = "john"

  val intro = s"name is $name"
  println(intro)
}
