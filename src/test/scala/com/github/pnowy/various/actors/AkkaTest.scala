package com.github.pnowy.various.actors

import akka.actor.{Actor, ActorSystem, Props}

class HelloActor(myName: String) extends Actor {

  def this() {
    this("NO_NAME")
  }

  override def receive: Receive = {
    case "hello" => println(s"hello $myName back at you")
    case _ => println("huh?")
  }

  @throws[Exception](classOf[Exception])
  override def preStart(): Unit = {
    super.preStart()
    println(s"Pre starting actor $myName")
  }
}

object AkkaTest extends App {
  // an actor needs an ActorSystem
  val system = ActorSystem("HelloSystem")
  // create and start the actor
  val fredActor = system.actorOf(Props(new HelloActor("Fred")), name = "fredActor")
  val noNameActor = system.actorOf(Props[HelloActor], name = "noNameActor")
  // send the actor two messages
  fredActor ! "hello"
  fredActor ! "buenos dias"
  noNameActor ! "hello"

  // shout down the system
  system.shutdown()

}
