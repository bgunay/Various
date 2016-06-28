package com.github.pnowy.various.basic

import java.text.DateFormat
import java.text.DateFormat._
import java.util.{Date, Locale}


object ExampleApp extends App {
  println("Hello")
  val now = new Date
  val df = getDateInstance(DateFormat.LONG, Locale.FRANCE)
  println(df.format(now))
  println(df format now)
}
