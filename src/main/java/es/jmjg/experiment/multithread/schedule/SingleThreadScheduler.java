package es.jmjg.experiment.multithread.schedule;

import java.util.concurrent.*;

public class SingleThreadScheduler {
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public String executeInTime(String test) throws ExecutionException, InterruptedException {
        Future<String> future = executorService.schedule(() -> test, 100, TimeUnit.MILLISECONDS);

        String result = null;
        try {
            result = future.get(200, TimeUnit.MILLISECONDS);
        } catch (TimeoutException ignored) {
        }

        executorService.shutdown();

        return result;
    }

    public String executeOutOfTime(String test) throws ExecutionException, InterruptedException {
        Future<String> future = executorService.schedule(() -> test, 300, TimeUnit.MILLISECONDS);

        String result = null;
        try {
            result = future.get(100, TimeUnit.MILLISECONDS);
        } catch (TimeoutException ignored) {
        }

        executorService.shutdown();

        return result;
    }
}
