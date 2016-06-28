package com.github.pnowy.various.concurrency.rxandakka;

public class AkkaEcho extends ObservableActor {
    @Override
    protected Object processMessage(Object message) {
        return message;
    }
}
