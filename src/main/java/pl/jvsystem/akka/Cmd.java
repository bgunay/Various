package pl.jvsystem.akka;

import java.io.Serializable;

public class Cmd implements Serializable {
    private final String data;

    public Cmd(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
