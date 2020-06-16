package com.ebook.scala.demo.casepak

/**
  * @Description:
  * @Authr: yaunde
  * @Date: 2020-05-25 01:15
  */
case class Account(name: String) {

}

object Test {
  def main(args: Array[String]): Unit = {
    var tuple1 = (1, "a", "b", true, 2)

    println(tuple1.productPrefix)

    for (item <- tuple1.productIterator) {
      print(item + " ")
    }
  }
}
