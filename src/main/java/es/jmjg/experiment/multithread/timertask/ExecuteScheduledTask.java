package es.jmjg.experiment.multithread.timertask;

import java.util.Timer;
import java.util.TimerTask;

public class ExecuteScheduledTask {
    public void execute() throws InterruptedException {
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                System.out.println("Repeated task performed");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Timer timer = new Timer("Timer");
        long delay = 1000L;
        long period = 1500L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);

        System.out.println("Repeated task should be pending");

        Thread.sleep(4000);

        System.out.println("Repeated task should be finished");
    }
}
