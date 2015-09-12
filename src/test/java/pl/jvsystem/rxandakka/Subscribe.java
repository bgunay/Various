package pl.jvsystem.rxandakka;

import rx.functions.Action1;

import java.io.Serializable;

/**
 * @author Przemek Nowak [przemek.nowak.pl@gmail.com]
 */
public class Subscribe implements Serializable {
    private final Action1 subscription;

    public Subscribe(Action1 subscription) {
        this.subscription = subscription;
    }

    public Action1 getSubscription() {
        return subscription;
    }
}
