package es.jmjg.experiment.multithread.waitandnotify;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {
    private final Data data;

    public Sender(Data data) {
        this.data = data;
    }

    public void run() {
        String[] packets = { "First packet", "Second packet", "Third packet", "Fourth packet", "End" };

        for (String packet : packets) {
            data.send(packet);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500));} catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}