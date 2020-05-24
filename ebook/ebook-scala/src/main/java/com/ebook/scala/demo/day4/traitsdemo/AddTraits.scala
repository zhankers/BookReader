package com.ebook.scala.demo.day4.traitsdemo

/**
  * @Description:
  * @Authr: yaunde
  * @Date: 2020-05-24 00:46
  */
class AddTraits {

  def main(args: Array[String]): Unit = {
    val mySql = new MySql with DB with File
  }

}

trait Operator {
  println("Operator...")

  def insert(id: Int)
}

trait Data extends Operator {
  println("Data...")

  override def insert(id: Int): Unit = println("insert data = " + id)
}

trait DB extends Data {
  println("DB...")

  override def insert(id: Int): Unit = {
    println("go db")

    super.insert(id)
  }
}

trait File extends Data {
  println("File...")
  override def insert(id: Int): Unit = {
    println("go file")
    super.insert(id)

  }
}

class MySql {}