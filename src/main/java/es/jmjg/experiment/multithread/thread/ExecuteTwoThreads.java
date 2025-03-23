package es.jmjg.experiment.multithread.thread;

public class ExecuteTwoThreads {
    public void execute(int milliseconds) {
        Concurrency thread1 = new Concurrency(1, milliseconds);
        Concurrency thread2 = new Concurrency(2, milliseconds);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
