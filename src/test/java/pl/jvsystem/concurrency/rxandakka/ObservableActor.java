package pl.jvsystem.concurrency.rxandakka;

import akka.actor.UntypedActor;

public abstract class ObservableActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Subscribe) {
            System.out.println("Subscribed!");
            getContext().become(newMessage -> {
                if (newMessage instanceof UnSubscribe) {
                    getContext().unbecome();
                    System.out.println("Unsubscribed!");
                } else {
                    Subscribe subscriber = (Subscribe) message;
                    subscriber.getSubscription().call(processMessage(newMessage));
                }
            });
        } else {
            System.out.println("Default behavior: "+message);
        }
    }

    protected abstract Object processMessage(Object message);

}
