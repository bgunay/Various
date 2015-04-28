package pl.jvsystem.actors

import akka.actor._

class TestActor extends Actor {
  override def receive: Receive = {
    case _ => println("a message was received")
  }
}

object SystemStopExample extends App {
  val system = ActorSystem("SystemStopExample")
  val actor = system.actorOf(Props[TestActor], "test")
  actor ! "hello"
  system.stop(actor)
  system.shutdown()
}
