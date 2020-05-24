package com.ebook.scala.demo.day1

/**
  * @Description:
  * @Authr: yaunde
  * @Date: 2020-05-01 15:41
  */
object ScalaType {
  def main(args: Array[String]): Unit = {
    var str:String = "123"
    var str2:String = "234"
    var num:Int = 123
    var floatNum:Float = 123.98F
    var longnum:Long = 123L
    var doubleNum:Double = 123.91
    var ch:Char = '1'
    num += 4

    printf("字符串拼接 " + str + str2)
    // 支持$符引用
    printf(s"111字符串拼接$num 长整型$longnum")
    printf(s"222字符串拼接2${num} 长整型${longnum+num}")


    // 类型推导
    var nu = 3
    println(nu.isInstanceOf[Int])
  }
}
