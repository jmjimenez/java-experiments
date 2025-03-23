package es.jmjg.experiment.multithread.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutor {
    private record DelayedRunnable(String name, int delay) {
        public Runnable getRunnable() {
            return () -> {
                System.out.println("Task " + name + " starts");
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task ends");
            };
        }
    }

    public void execute() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.submit((new DelayedRunnable("task 1", 500)).getRunnable());
        executor.submit((new DelayedRunnable("task 2", 500)).getRunnable());

        TimeUnit.MILLISECONDS.sleep(1200);
        executor.shutdown();
    }
}
