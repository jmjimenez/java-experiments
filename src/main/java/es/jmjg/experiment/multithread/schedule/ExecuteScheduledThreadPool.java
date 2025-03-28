package es.jmjg.experiment.multithread.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecuteScheduledThreadPool {
    public void execute() throws InterruptedException {
        long taskDelay = 1000;
        long executorShutdownDelay = 2000;
        Runnable scheduledTask = () -> System.out.println("Scheduled task executed after 1 second");

        try (ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2)) {
            executorService.schedule(scheduledTask, taskDelay, TimeUnit.MILLISECONDS);

            System.out.println("Scheduled task should be pending");

            executorService.schedule(() -> {
                executorService.shutdown();
                System.out.println("ScheduledExecutorService shut down");
            }, executorShutdownDelay, TimeUnit.MILLISECONDS);
        }

        System.out.println("Scheduled task should be finished");
    }
}
