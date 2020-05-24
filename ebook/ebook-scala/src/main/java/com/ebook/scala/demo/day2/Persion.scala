package com.ebook.scala.demo.day2

/**
  * @Description:
  * @Authr: yaunde
  * @Date: 2020-05-23 16:33
  */
class Persion {
  var name:String = _
  def this(name: String) {
    this
    this.name = name
  }
}
class Emp(name:String) extends Persion(name) {
  def print()  {
    println("name = " + this.name)
  }
}

object Persion {
  def main(args: Array[String]): Unit = {
    val xiaoming = new Emp("xiaoming")
    xiaoming.print
  }
}