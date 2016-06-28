package pl.jvsystem.concurrency.rxandakka;

import rx.functions.Action1;

import java.io.Serializable;

public class Subscribe implements Serializable {
    private final Action1 subscription;

    public Subscribe(Action1 subscription) {
        this.subscription = subscription;
    }

    public Action1 getSubscription() {
        return subscription;
    }
}
