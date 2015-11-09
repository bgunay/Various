package pl.jvsystem.akka;

import java.io.Serializable;

/**
 * @author Przemek Nowak [przemek.nowak.pl@gmail.com]
 */
public class Evt implements Serializable {
    private final String data;

    public Evt(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
