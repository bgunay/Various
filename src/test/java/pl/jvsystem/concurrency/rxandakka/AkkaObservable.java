package pl.jvsystem.concurrency.rxandakka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import rx.Observable;
import rx.functions.Action1;

import java.util.ArrayList;
import java.util.List;

public class AkkaObservable {

    public static void main(String[] args) throws InterruptedException {



        ActorSystem system = ActorSystem.create("client");

        final ActorRef actor = system.actorOf(Props.create(AkkaEcho.class), "rcv");

        final Object mutex = new Object();


        final List<String> results = new ArrayList<>();
        final List<String> distinctResults = new ArrayList<>();

        final Observable<String> observable = ObservableUtil.fromActor(actor);

        observable.subscribe(new Action1<String>() {
            @Override
            public void call(String o) {
                System.out.println(o);

                if (o.equals("done")) {
                    synchronized (mutex) {
                        mutex.notify();
                    }
                } else {
                    results.add(o);
                }
            }
        });

        observable.distinct().subscribe(new Action1<String>() {
            @Override
            public void call(String o) {
                distinctResults.add(o);
            }
        });

        actor.tell("foo",  ActorRef.noSender());
        actor.tell("foo",  ActorRef.noSender());
        actor.tell("foo",  ActorRef.noSender());
        actor.tell("bar", ActorRef.noSender());
        actor.tell("done", ActorRef.noSender());

        synchronized (mutex){ mutex.wait(); }


//        final Observable<String> observable = ObservableUtil.fromActor(actor);
//
//        observable.subscribe(System.out::println);
//
//        actor.tell("foo", ActorRef.noSender());
//        actor.tell("foo", ActorRef.noSender());
//        actor.tell("foo", ActorRef.noSender());
//        actor.tell("bar", ActorRef.noSender());
//        actor.tell("done", ActorRef.noSender());

        system.shutdown();
    }


}
