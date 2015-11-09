package pl.jvsystem.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * @author Przemek Nowak [przemek.nowak.pl@gmail.com]
 */
public class PersistentActorExample {
    public static void main(String[] args) throws Exception {
        final ActorSystem system = ActorSystem.create("example");
        final ActorRef persistentActor =
                system.actorOf(Props.create(ExamplePersistentActor.class), "persistentActor-4-java");

        persistentActor.tell(new Cmd("foo"), null);
//        persistentActor.tell("print", null);
        persistentActor.tell(new Cmd("baz"), null);
//        persistentActor.tell("print", null);
        persistentActor.tell(new Cmd("bar"), null);
//        persistentActor.tell("print", null);
        persistentActor.tell("snap", null);
        persistentActor.tell(new Cmd("buzz"), null);
        persistentActor.tell("print", null);

        Thread.sleep(2000);
        system.shutdown();
    }
}
