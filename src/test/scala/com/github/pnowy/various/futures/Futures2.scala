package com.github.pnowy.various.futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Futures2 extends App {
   implicit val baseTime = System.currentTimeMillis

  def longRunningComputation(i: Int): Future[Int] = Future {
    sleep(100)
    i + 1
  }

  longRunningComputation(5).onComplete {
    case Success(res) => println(s"res = $res")
    case Failure(e) => e.printStackTrace()
  }


   sleep(1000)
 }
