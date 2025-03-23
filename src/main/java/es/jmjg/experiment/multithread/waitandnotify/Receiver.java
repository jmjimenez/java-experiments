package es.jmjg.experiment.multithread.waitandnotify;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    private final Data load;

    public Receiver(Data load) {
        this.load = load;
    }

    public void run() {
        for (String receivedMessage = load.receive(); !"End".equals(receivedMessage); receivedMessage = load.receive()) {

            System.out.println(receivedMessage);

            try {
                //noinspection BusyWait
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}