package pl.jvsystem.concurrency.rxandakka;

public class AkkaMapEcho extends ObservableActor {
    @Override
    protected Object processMessage(Object message) {
        String m = (String) message;
        return  m + " mapped!";
    }
}
