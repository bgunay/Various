package pl.jvsystem.basic

import java.text.DateFormat
import java.text.DateFormat._
import java.util.{Locale, Date}


object ExampleApp extends App {
  println("Hello")
  val now = new Date
  val df = getDateInstance(DateFormat.LONG, Locale.FRANCE)
  println(df.format(now))
  println(df format now)
}
