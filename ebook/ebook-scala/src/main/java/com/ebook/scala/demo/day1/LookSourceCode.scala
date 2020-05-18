package com.ebook.scala.demo.day1

/**
  * @Description:
  * @Authr: yaunde
  * @Date: 2020-05-01 15:52
  */
object LookSourceCode {
  def main(args: Array[String]): Unit = {
    val nums = new Array[Int](10)
    for (elem <- nums) {
      printf("item  = " + elem)
    }
  }
}
