package com.github.pnowy.various.patterns.behavioral.state.mypattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 02.06.13 13:17
 */
public class Client {
    public static void main(String[] args) {
        final StateContext SC = new StateContext();

        SC.writeName("Monday");
        SC.writeName("Tuesday");
        SC.writeName("Wednesday");
        SC.writeName("Thursday");
        SC.writeName("Friday");
        SC.writeName("Saturday");
        SC.writeName("Sunday");
    }
}
