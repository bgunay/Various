package com.github.pnowy.various.actors

import akka.actor._

class Benny extends Actor {
  override def receive: Receive = {
    case _ => println("Kenny received a message")
  }
}

class Parent extends Actor {
  // start Kenny as a child then keep an eye on it
  val kenny = context.actorOf(Props[Benny], name = "Kenny")
  context.watch(kenny)

  override def receive: Actor.Receive = {
    case Terminated(actor) => println("OMG, they killed kenny")
    case _ => println("Parent received a message")
  }
}

object DeadWatchTest extends App {
  val system = ActorSystem("DeathWatchTest")

  val parent = system.actorOf(Props[Father], "Parent")

  val kenny = system.actorSelection("/user/Parent/Kenny")
  kenny ! PoisonPill
  Thread.sleep(5000)
  system.shutdown()

}
