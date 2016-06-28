package com.github.pnowy.various.concurrency.deamon;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class DaemonThread extends Thread {

    @Override
    public void run() {
        try {
            while (true) {
                log.info("Daemon thread is running");
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {
            log.error("", ie);
        } finally {
            log.info("Daemon Thread exiting"); // never called
        }
    }

}
