package es.jmjg.experiment.multithread.thread;

public class Concurrency extends Thread {
    private final int loopNum;
    private final int milliseconds;

    Concurrency(int loopNum, int milliseconds) {
        this.loopNum = loopNum;
        this.milliseconds = milliseconds;
    }

    @Override
    public void run() {
        for (byte i = 1; i <= 5; i++) {
            try { Thread.sleep(milliseconds); } catch(InterruptedException e) { System.out.println(e); }
            System.out.println("Loop " + this.loopNum + ", Iteration: " + i);
        }
    }
}