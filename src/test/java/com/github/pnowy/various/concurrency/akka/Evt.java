package com.github.pnowy.various.concurrency.akka;

import java.io.Serializable;

class Evt implements Serializable {
    private final String data;

    public Evt(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
