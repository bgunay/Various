package pl.jvsystem.actors

import akka.actor._

case class CreateChild(name: String)
case class Name(name: String)

class Child extends Actor {
  var name = "No name"

  @throws[Exception](classOf[Exception])
  override def postStop(): Unit = {
    println(s"D'oh! They killed me ($name): ${self.path}")
  }

  override def receive: Receive = {
    case Name(varname) => this.name = varname
    case _ => println(s"Child $name got message")
  }
}

class Parent extends Actor {
  override def receive: Actor.Receive = {
    case CreateChild(name) =>
      // parent creates new child here
      println(s"Parent about to create Child($name)")
      val child = context.actorOf(Props[Child], name = s"$name")
      child ! Name(name)
    case _ => println(s"Parent got some other message.")
  }
}

object ParentChildDemo extends App {
  val system = ActorSystem("ParentChildTest")
  val parent = system.actorOf(Props[Parent], "Parent")

  // send messages to Parent to create to child actors
  parent ! CreateChild("Jonathan")
  parent ! CreateChild("Michael")
  Thread.sleep(500)

  // lookup Jonathan, thenn kill it
  println("Sending Jonathan a PoisonPill ... :)")
  val jonathan = system.actorSelection("/user/Parent/Jonathan")
  jonathan ! PoisonPill

  Thread.sleep(5000)
  system.shutdown()

}
