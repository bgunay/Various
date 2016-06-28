package com.github.pnowy.various.ocjp.chapter9;

import java.util.List;

public class Generic<E> {
    private E var;

    public static void main(String[] args) {

    }
    
    public static Number sumArray(List<? extends Number> in) {
	    double sum = 0;
        for (Number number : in) {
            
        }
        //	in.add(23);
	    return sum;
    }

}
