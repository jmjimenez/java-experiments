package es.jmjg.experiment.multithread.fixedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolExecutor {
    public void execute(int numberOfConcurrency) {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfConcurrency);

        for (int i = 0; i < numberOfConcurrency; i++) {
            Runnable worker = new Concurrency(i);
            executor.execute(worker);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
