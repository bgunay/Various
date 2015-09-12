package pl.jvsystem.rxandakka;

/**
 * @author Przemek Nowak [przemek.nowak.pl@gmail.com]
 */
public class AkkaEcho extends ObservableActor {
    @Override
    protected Object processMessage(Object message) {
        return message;
    }
}
