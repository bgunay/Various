package com.github.pnowy.various.futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Random, Success}


object Example1 extends App {
  println("starting calculation...")
  val f = Future {
    sleep(Random.nextInt(500))
    42
  }

  println("before onComplete")
  f.onComplete {
    case Success(value) => println(s"Got the callback, meaning = $value")
    case Failure(e) => e.printStackTrace()
  }
  f.onSuccess {
    case result => println(s"onSuccess: $result")
  }
  f.onFailure {
    case result => println(s"onFailure: $result")
  }

  println("A..."); sleep(100)
  println("B..."); sleep(100)
  println("C..."); sleep(100)
  println("D..."); sleep(100)
  println("E..."); sleep(100)
  println("F..."); sleep(100)
  println("G..."); sleep(100)

  sleep(2000)

}
