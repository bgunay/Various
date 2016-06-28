package com.github.pnowy.various.actors

import akka.actor._
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

case object AskNameMessage

class TestActor extends Actor {
  override def receive: Receive = {
    case AskNameMessage => sender ! "Fred"
    case _ => println("that was unexpected")
  }
}

object AskTest extends App {
  val system = ActorSystem("AskTest")

  val myActor = system.actorOf(Props[TestStopActor], "myActor")

  implicit  val timeout = Timeout(5 seconds)
  val future = myActor ? AskNameMessage
  val result = Await.result(future, timeout.duration).asInstanceOf[String]
  println(result)

  val future2: Future[String] = ask(myActor, AskNameMessage).mapTo[String]
  val result2 = Await.result(future2, 1 second)
  println(result2)

  system.shutdown()

}
