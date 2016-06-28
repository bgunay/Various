package com.github.pnowy.various.concurrency.akka;

import akka.japi.pf.ReceiveBuilder;
import akka.persistence.AbstractPersistentActor;
import akka.persistence.SnapshotOffer;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

public class ExamplePersistentActor extends AbstractPersistentActor {

    private ExampleState state = new ExampleState();

    public int getNumEvents() {
        return state.size();
    }

    @Override
    public String persistenceId() {
        return "sample-id-1";
    }

    @Override
    public PartialFunction<Object, BoxedUnit> receiveRecover() {
        return ReceiveBuilder.
                match(Evt.class, state::update).
                match(SnapshotOffer.class, ss -> state = (ExampleState) ss.snapshot()).build();
    }

    @Override
    public PartialFunction<Object, BoxedUnit> receiveCommand() {
        return ReceiveBuilder.
                match(Cmd.class, c -> {
                    final String data = c.getData();
                    final Evt evt1 = new Evt(data + "-" + getNumEvents());
//                    final Evt evt2 = new Evt(data + "-" + (getNumEvents() + 1));
                    persist(evt1, (Evt evt) -> {
                        state.update(evt);
//                        if (evt.equals(evt2)) {
                            context().system().eventStream().publish(evt);
//                        }
                    });
                }).
                match(String.class, s -> s.equals("snap"), s -> saveSnapshot(state.copy())).
                match(String.class, s -> s.equals("print"), s -> System.out.println(state)).
                build();
    }
}
