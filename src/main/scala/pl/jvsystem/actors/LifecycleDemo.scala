package pl.jvsystem.actors

import akka.actor._

case object ForceRestart

class Kenny extends Actor {
  println("entered the kenny constructor")

  @throws[Exception](classOf[Exception])
  override def preStart(): Unit = {
    println("kenny: preStart")
  }

  @throws[Exception](classOf[Exception])
  override def postStop(): Unit = {
    println("kenny: postStop")
  }

  @throws[Exception](classOf[Exception])
  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println("kenny: preRestart")
    println(s"  MESSAGE: ${message.getOrElse("")}")
    println(s"  REASON: ${reason.getMessage}")
    super.preRestart(reason, message)
  }

  @throws[Exception](classOf[Exception])
  override def postRestart(reason: Throwable): Unit = {
    println("kenny: postRestart")
    println(s"  REASON: ${reason.getMessage}")
    super.postRestart(reason)
  }

  override def receive: Receive = {
    case ForceRestart => throw new Exception("Boom!")
    case _ => println("Kenny received a message")
  }
}

object LifecycleDemo extends App {
  val system = ActorSystem("LifecycleDemo")
  val kenny = system.actorOf(Props[Kenny], name = "kenny")

  println("sending kenny a simple String message")
  kenny ! "hello"
  Thread.sleep(1000)

  println("make kenny restart")
  kenny ! ForceRestart
  Thread.sleep(1000)

  println("stopping kennny")
  system.stop(kenny)

  system.shutdown()

}
