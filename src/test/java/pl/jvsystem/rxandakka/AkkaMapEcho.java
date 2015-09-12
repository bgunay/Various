package pl.jvsystem.rxandakka;

/**
 * @author Przemek Nowak [przemek.nowak.pl@gmail.com]
 */
public class AkkaMapEcho extends ObservableActor {
    @Override
    protected Object processMessage(Object message) {
        String m = (String) message;
        return  m + " mapped!";
    }
}
