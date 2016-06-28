package com.github.pnowy.various.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Random;

/**
 * Author: Przemek Nowak [przemek.nowak.pl@gmail.com]
 */
@WebService
public class RandService {
    private static final int maxRands = 16;

    @WebMethod // optional but helpful annotation
    public int next1() {
        return new Random().nextInt();
    }

    @WebMethod // optional but helpful annotation
    public int[] nextN(final int n) {

        final int k = (n > maxRands) ? maxRands : Math.abs(n);
        int[] rands = new int[k];
        Random r = new Random();
        for (int i = 0; i < k; i++) rands[i] = r.nextInt();
        return rands;
    }
}

