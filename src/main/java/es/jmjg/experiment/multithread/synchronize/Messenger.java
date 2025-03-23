package es.jmjg.experiment.multithread.synchronize;

public class Messenger {
    private final int delay;

    public Messenger(int delay) {
        this.delay = delay;
    }

    public Messenger() {
        this(500);
    }

    public synchronized void sendMessage(String msg) {
        System.out.println(Thread.currentThread().getName() + ", Sending message: " + msg);

        try {
            Thread.sleep(delay);
        } catch(InterruptedException e) {
            System.out.println("Thread interrupted: " + e);
        }

        System.out.println(Thread.currentThread().getName() + ", Message sent: " + msg);
    }
}
