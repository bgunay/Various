package pl.jvsystem.ws;

import javax.xml.ws.Endpoint;

/**
 * Author: Przemek Nowak [przemek.nowak.pl@gmail.com]
 */
public class RandPublisher {
    public static void main(String[] args) {
        final String url = "http://localhost:8888/rs";
        System.out.println("Publishing RandService at endpoint " + url);
        Endpoint.publish(url, new RandService());
    }
}
