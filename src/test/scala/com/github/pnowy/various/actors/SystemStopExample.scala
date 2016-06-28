package com.github.pnowy.various.actors

import akka.actor._

class TestStopActor extends Actor {
  override def receive: Receive = {
    case _ => println("a message was received")
  }
}

object SystemStopExample extends App {
  val system = ActorSystem("SystemStopExample")
  val actor = system.actorOf(Props[TestStopActor], "test")
  actor ! "hello"
  system.stop(actor)
  system.shutdown()
}
