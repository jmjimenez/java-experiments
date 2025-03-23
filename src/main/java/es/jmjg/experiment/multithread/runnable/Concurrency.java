package es.jmjg.experiment.multithread.runnable;

public class Concurrency implements Runnable {
    private final int loopNum;
    private final int delay;

    Concurrency(int loopNum, int delay) {
        this.loopNum = loopNum;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (byte i = 1; i <= 5; i++) {
            try {
                Thread.sleep(delay);
            } catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Loop " + this.loopNum + ", Iteration: " + i);
        }
    }
}