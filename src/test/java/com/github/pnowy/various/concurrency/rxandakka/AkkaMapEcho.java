package com.github.pnowy.various.concurrency.rxandakka;

public class AkkaMapEcho extends ObservableActor {
    @Override
    protected Object processMessage(Object message) {
        String m = (String) message;
        return  m + " mapped!";
    }
}
