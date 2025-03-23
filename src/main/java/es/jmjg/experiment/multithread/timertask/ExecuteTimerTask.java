package es.jmjg.experiment.multithread.timertask;

import java.util.Timer;
import java.util.TimerTask;

public class ExecuteTimerTask {
    public void execute() throws InterruptedException {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Scheduled task performed");
            }
        };

        Timer timer = new Timer("Timer");
        long delay = 1000L;
        timer.schedule(task, delay);

        System.out.println("Schedule should be pending");

        Thread.sleep(1500);

        System.out.println("Schedule should be finished");
    }
}
