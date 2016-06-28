package pl.jvsystem.concurrency.rxandakka;

import akka.actor.ActorRef;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

public class ObservableUtil {

    public static <T> Observable<T> fromActor(final ActorRef actor) {
        final PublishSubject<T> subj = PublishSubject.create();

        Observable<T> observable = Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(final Subscriber<? super T> subscriber) {

                /**
                 * Create an initial subscribe method that modifies
                 * the actors default behavior to proxy the request to the
                 * subscribers 'onNext' function.  This way
                 * when someone posts to the actor, we intercept the actors RESPONSE
                 * and pipe it into the subscribers work queue.
                 */
                Subscribe msg = new Subscribe(new Action1<T>() {
                    @Override
                    public void call(T o) {
                        subscriber.onNext(o);
                    }
                });

                actor.tell(msg, ActorRef.noSender());
            }
        });
        /**
         * Create one subscriber to this actor observable and re-proxy the result
         * to the subject (this lets other people subscribe to the subject, and keeps
         * the akka observable from having to worry about managing who is substring to what
         * and de-muddles up the behavior modification code. this call also invokes the
         * subscribe command pattern above.
         */
        observable.subscribe(subj::onNext);

        /**
         * Return the subject's observable stream for others to subscribe on
         */
        return subj.asObservable();
    }

}
