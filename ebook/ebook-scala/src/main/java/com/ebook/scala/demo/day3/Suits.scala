package com.ebook.scala.demo.day3

/**
  * @Description:
  * @Authr: yaunde
  * @Date: 2020-05-24 00:17
  */
object Suits extends Enumeration {

  type Suits = Value // 给Value取别名
  val Spade = Value("♠")
  val Club = Value("♣")
  val Heart = Value("♥")
  val Diamond = Value("")

  override def toString(): String = Suits.values.mkString(",")

  def isRed(suit:Suits) : Boolean = {
    suit == Heart || suit == Diamond
//    if (suit == Heart || suit == Diamond) {
//      true
//    } else
//      false
  }


  def main(args: Array[String]): Unit = {
    println(Suits)
    println(isRed(Suits.Diamond))
  }
}
