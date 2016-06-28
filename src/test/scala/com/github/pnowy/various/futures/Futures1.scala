package com.github.pnowy.various.futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

object Futures1 extends App {
  implicit val baseTime = System.currentTimeMillis

  val f = Future {
    sleep(500)
    1 + 1
  }

  val result = Await.result(f, 1 seconds)
  println(result)

  sleep(1000)
}
