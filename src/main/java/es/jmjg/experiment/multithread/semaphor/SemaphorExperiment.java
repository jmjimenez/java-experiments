package es.jmjg.experiment.multithread.semaphor;

import java.util.concurrent.*;

public class SemaphorExperiment {
    private final java.util.concurrent.ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void execute() throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);

        Runnable runnable = () -> {
            System.out.println("Task starts");
            try {
                semaphore.acquire();
                TimeUnit.MILLISECONDS.sleep(100);
                semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task ends");
        };

        System.out.println("Before submitting tasks");

        for (int i = 0; i < 6; i++) {
            executorService.submit(runnable);
        }

        TimeUnit.MILLISECONDS.sleep(150);

        System.out.println("After submitting tasks");


        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(500, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
